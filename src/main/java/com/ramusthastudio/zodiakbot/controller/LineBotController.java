package com.ramusthastudio.zodiakbot.controller;

import com.google.gson.Gson;
import com.linecorp.bot.client.LineSignatureValidator;
import com.ramusthastudio.zodiakbot.model.DiscoverMovies;
import com.ramusthastudio.zodiakbot.model.Result;
import com.ramusthastudio.zodiakbot.model.Data;
import com.ramusthastudio.zodiakbot.model.Events;
import com.ramusthastudio.zodiakbot.model.Message;
import com.ramusthastudio.zodiakbot.model.Payload;
import com.ramusthastudio.zodiakbot.model.Postback;
import com.ramusthastudio.zodiakbot.model.ResultMovies;
import com.ramusthastudio.zodiakbot.model.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import static com.ramusthastudio.zodiakbot.util.BotHelper.FOLLOW;
import static com.ramusthastudio.zodiakbot.util.BotHelper.IMG_HOLDER;
import static com.ramusthastudio.zodiakbot.util.BotHelper.JOIN;
import static com.ramusthastudio.zodiakbot.util.BotHelper.KEY_TODAY;
import static com.ramusthastudio.zodiakbot.util.BotHelper.LEAVE;
import static com.ramusthastudio.zodiakbot.util.BotHelper.MESSAGE;
import static com.ramusthastudio.zodiakbot.util.BotHelper.MESSAGE_TEXT;
import static com.ramusthastudio.zodiakbot.util.BotHelper.POSTBACK;
import static com.ramusthastudio.zodiakbot.util.BotHelper.SOURCE_GROUP;
import static com.ramusthastudio.zodiakbot.util.BotHelper.SOURCE_ROOM;
import static com.ramusthastudio.zodiakbot.util.BotHelper.SOURCE_USER;
import static com.ramusthastudio.zodiakbot.util.BotHelper.UNFOLLOW;
import static com.ramusthastudio.zodiakbot.util.BotHelper.getCinemaToday;
import static com.ramusthastudio.zodiakbot.util.BotHelper.getSearchMovies;
import static com.ramusthastudio.zodiakbot.util.BotHelper.greetingMessage;
import static com.ramusthastudio.zodiakbot.util.BotHelper.greetingMessageGroup;
import static com.ramusthastudio.zodiakbot.util.BotHelper.instructionTweetsMessage;
import static com.ramusthastudio.zodiakbot.util.BotHelper.pushMessage;
import static com.ramusthastudio.zodiakbot.util.BotHelper.replayMessage;
import static com.ramusthastudio.zodiakbot.util.BotHelper.unfollowMessage;
import static com.ramusthastudio.zodiakbot.util.CinemaHelper.generateCinemaId;

@RestController
@RequestMapping(value = "/linebot")
public class LineBotController {
  private static final Logger LOG = LoggerFactory.getLogger(LineBotController.class);

  @Autowired
  @Qualifier("line.bot.channelSecret")
  String fChannelSecret;
  @Autowired
  @Qualifier("line.bot.channelToken")
  String fChannelAccessToken;
  @Autowired
  @Qualifier("com.bioskop.base_url")
  String fBioskopBaseUrl;
  @Autowired
  @Qualifier("com.bioskop.api_key")
  String fBioskopApiKey;
  @Autowired
  @Qualifier("com.themoviedb.api_key")
  String fTheMovieApiKey;
  @Autowired
  @Qualifier("com.themoviedb.base_url")
  String fTheMovieBaseUrl;
  @Autowired
  @Qualifier("com.themoviedb.base_imdb_url")
  String fTheMovieBaseImdbUrl;
  @Autowired
  @Qualifier("com.themoviedb.base_video_url")
  String fTheMovieVideoUrl;
  @Autowired
  @Qualifier("com.themoviedb.base_img_url")
  String fTheMovieBaseImgUrl;

  @RequestMapping(value = "/callback", method = RequestMethod.POST)
  public ResponseEntity<String> callback(
      @RequestHeader("X-Line-Signature") String aXLineSignature,
      @RequestBody String aPayload) {

    LOG.info("XLineSignature: {} ", aXLineSignature);
    LOG.info("Payload: {} ", aPayload);

    LOG.info("The Signature is: {} ", (aXLineSignature != null && aXLineSignature.length() > 0) ? aXLineSignature : "N/A");
    final boolean valid = new LineSignatureValidator(fChannelSecret.getBytes()).validateSignature(aPayload.getBytes(), aXLineSignature);
    LOG.info("The Signature is: {} ", valid ? "valid" : "tidak valid");

    LOG.info("Start getting payload ");
    try {

      Gson gson = new Gson();
      Payload payload = gson.fromJson(aPayload, Payload.class);
      Events event = payload.events()[0];

      String eventType = event.type();
      String replayToken = event.replyToken();
      Source source = event.source();
      long timestamp = event.timestamp();
      Message message = event.message();
      Postback postback = event.postback();

      String userId = source.userId();
      String sourceType = source.type();

      LOG.info("source type : {} ", sourceType);
      switch (sourceType) {
        case SOURCE_USER:
          sourceUserProccess(eventType, replayToken, timestamp, message, postback, userId);
          break;
        case SOURCE_GROUP:
          // sourceGroupProccess(eventType, replayToken, postback, message, source);
          break;
        case SOURCE_ROOM:
          // sourceGroupProccess(eventType, replayToken, postback, message, source);
          break;
      }
    } catch (Exception ae) {
      LOG.error("Erro process payload : {} ", ae.getMessage());
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
  private void sourceGroupProccess(String aEventType, String aReplayToken, Postback aPostback, Message aMessage, Source aSource) {
    LOG.info("event : {} ", aEventType);
    try {
      switch (aEventType) {
        case LEAVE:
          unfollowMessage(fChannelAccessToken, aSource.groupId());
          break;
        case JOIN:
          LOG.info("Greeting Message");
          greetingMessageGroup(fChannelAccessToken, aSource.groupId());
          break;
        case MESSAGE:
          if (aMessage.type().equals(MESSAGE_TEXT)) {
            String text = aMessage.text();
            replayMessage(fChannelAccessToken, aReplayToken, text);

          } else {
            pushMessage(fChannelAccessToken, aSource.groupId(), "Aku gak ngerti nih, " +
                "aku ini cuma bot yang bisa membaca ramalan zodiak, jadi jangan tanya yang aneh aneh dulu yah");
          }
          break;
        case POSTBACK:
          break;
      }
    } catch (IOException aE) { LOG.error("Message {}", aE.getMessage()); }
  }

  private void sourceUserProccess(String aEventType, String aReplayToken, long aTimestamp, Message aMessage, Postback aPostback, String aUserId) {
    LOG.info("event : {} ", aEventType);
    try {
      switch (aEventType) {
        case UNFOLLOW:
          unfollowMessage(fChannelAccessToken, aUserId);
          break;
        case FOLLOW:
          LOG.info("Greeting Message");
          greetingMessage(fChannelAccessToken, aUserId);
          instructionTweetsMessage(fChannelAccessToken, aUserId);
          break;
        case MESSAGE:
          if (aMessage.type().equals(MESSAGE_TEXT)) {
            String text = aMessage.text();
            replayMessage(fChannelAccessToken, aReplayToken, text);
            if (text.toLowerCase().startsWith(KEY_TODAY.toLowerCase())) {
              String city = text.substring(KEY_TODAY.length(), text.length()).trim();
              String cityCandidate = generateCinemaId(city);
              if (cityCandidate != null) {
                LOG.info("BioskopBaseUrl {} BioskopApiKey {} cityID {}", fBioskopBaseUrl, fBioskopApiKey, cityCandidate);
                Response<Result> cinemaToday = getCinemaToday(fBioskopBaseUrl, fBioskopApiKey, cityCandidate);
                LOG.info("cinemaToday code {} message {}", cinemaToday.code(), cinemaToday.message());

                if (cinemaToday.isSuccessful()) {
                  Result cinemaRes = cinemaToday.body();
                  LOG.info("Kota {} Tanggal {}", cinemaRes.getCity(), cinemaRes.getDate());

                  List<Data> dataCinema = cinemaRes.getCinemaDatas();
                  List<Data> newCinema = new ArrayList<>();
                  for (Data data : dataCinema) {
                    String title = data.getMovie().toString();
                    Response<DiscoverMovies> moviesDb = getSearchMovies(fTheMovieBaseUrl, fTheMovieApiKey, title);
                    LOG.info("DiscoverMovies code {} message {}", moviesDb.code(), moviesDb.message());
                    if (moviesDb.isSuccessful()) {
                      DiscoverMovies moviesBody = moviesDb.body();
                      List<ResultMovies> moviesRes = moviesBody.getResultMovies();
                      if (moviesRes.size() != 0) {
                        ResultMovies movie = moviesRes.get(0);
                        String coverUrl;
                        if (movie.getBackdropPath() != null) {
                          coverUrl = movie.getBackdropPath();
                        }else {
                          coverUrl = IMG_HOLDER;
                        }
                        data.setPoster(coverUrl);
                        newCinema.add(data);
                      }
                    }
                    LOG.info("Movie {} genre {} poster {}", data.getMovie(), data.getDuration(), data.getPoster());
                  }
                  for (Data data : newCinema) {
                    LOG.info("new Movie {} genre {} poster {}", data.getMovie(), data.getDuration(), data.getPoster());
                  }
                } else {
                  pushMessage(fChannelAccessToken, aUserId, "Hmmm... ada yang salah nih di server, coba beberapa saat lagi yah...");
                }
              } else {
                pushMessage(fChannelAccessToken, aUserId, "Hmmm... aku gak tahu nih kota mana yang kamu input, coba kota lain");
              }
            }
          } else {
            pushMessage(fChannelAccessToken, aUserId, "Aku gak ngerti nih, jangan tanya yang aneh aneh dulu yah");
          }
          break;
        case POSTBACK:
          break;
      }
    } catch (IOException aE) { LOG.error("Message {}", aE.getMessage()); }
  }

}
