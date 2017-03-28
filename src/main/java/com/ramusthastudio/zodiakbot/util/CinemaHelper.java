package com.ramusthastudio.zodiakbot.util;

public final class CinemaHelper {
  public static final String AMBON = "Ambon";
  public static final String BALIKPAPAN = "Balikpapan";
  public static final String BANDUNG = "Bandung";
  public static final String BANJARMASIN = "Banjarmasin";
  public static final String BATAM = "Batam";
  public static final String BEKASI = "Bekasi";
  public static final String BENGKULU = "Bengkulu";
  public static final String BINJAI = "Binjai";
  public static final String BOGOR = "Bogor";
  public static final String CIREBON = "Cirebon";
  public static final String GORONTALO = "Gorontalo";
  public static final String JAKARTA = "Jakarta";
  public static final String JAMBI = "Jambi";
  public static final String JAYAPURA = "Jayapura";
  public static final String KARAWANG = "Karawang";
  public static final String LAMPUNG = "Lampung";
  public static final String MAKASSAR = "Makassar";
  public static final String MALANG = "Malang";
  public static final String MANADO = "Manado";
  public static final String MATARAM = "Mataram";
  public static final String MEDAN = "Medan";
  public static final String PADANG = "Padang";
  public static final String PALANGKARAYA = "Palangkaraya";
  public static final String PALEMBANG = "Palembang";
  public static final String PALU = "Palu";
  public static final String PEKANBARU = "Pekanbaru";
  public static final String PONTIANAK = "Pontianak";
  public static final String SAMARINDA = "Samarinda";
  public static final String SEMARANG = "Semarang";
  public static final String SINGKAWANG = "Singkawang";
  public static final String SURABAYA = "Surabaya";
  public static final String SURAKARTA = "Surakarta";
  public static final String TANGERANG = "Tangerang";
  public static final String TASIKMALAYA = "Tasikmalaya";
  public static final String YOGYAKARTA = "Yogyakarta";

  public static final String ID_AMBON = "32";
  public static final String ID_BALIKPAPAN = "6";
  public static final String ID_BANDUNG = "2";
  public static final String ID_BANJARMASIN = "31";
  public static final String ID_BATAM = "1";
  public static final String ID_BEKASI = "4";
  public static final String ID_BENGKULU = "34";
  public static final String ID_BINJAI = "33";
  public static final String ID_BOGOR = "3";
  public static final String ID_CIREBON = "8";
  public static final String ID_GORONTALO = "38";
  public static final String ID_JAKARTA = "10";
  public static final String ID_JAMBI = "21";
  public static final String ID_JAYAPURA = "37";
  public static final String ID_KARAWANG = "43";
  public static final String ID_LAMPUNG = "22";
  public static final String ID_MAKASSAR = "16";
  public static final String ID_MALANG = "18";
  public static final String ID_MANADO = "19";
  public static final String ID_MATARAM = "41";
  public static final String ID_MEDAN = "17";
  public static final String ID_PADANG = "42";
  public static final String ID_PALANGKARAYA = "35";
  public static final String ID_PALEMBANG = "20";
  public static final String ID_PALU = "39";
  public static final String ID_PEKANBARU = "30";
  public static final String ID_PONTIANAK = "24";
  public static final String ID_SAMARINDA = "13";
  public static final String ID_SEMARANG = "14";
  public static final String ID_SINGKAWANG = "40";
  public static final String ID_SURABAYA = "12";
  public static final String ID_SURAKARTA = "29";
  public static final String ID_TANGERANG = "15";
  public static final String ID_TASIKMALAYA = "36";
  public static final String ID_YOGYAKARTA = "23";

  public static String generateCinemaId(String aCity) {
    if (aCity.equalsIgnoreCase(AMBON)) {
      return ID_AMBON;
    } else if (aCity.equalsIgnoreCase(BALIKPAPAN)) {
      return ID_BALIKPAPAN;
    } else if (aCity.equalsIgnoreCase(BANDUNG)) {
      return ID_BANDUNG;
    } else if (aCity.equalsIgnoreCase(BANJARMASIN)) {
      return ID_BANJARMASIN;
    } else if (aCity.equalsIgnoreCase(BATAM)) {
      return ID_BATAM;
    } else if (aCity.equalsIgnoreCase(BEKASI)) {
      return ID_BEKASI;
    } else if (aCity.equalsIgnoreCase(BENGKULU)) {
      return ID_BENGKULU;
    } else if (aCity.equalsIgnoreCase(BINJAI)) {
      return ID_BINJAI;
    } else if (aCity.equalsIgnoreCase(BOGOR)) {
      return ID_BOGOR;
    } else if (aCity.equalsIgnoreCase(CIREBON)) {
      return ID_CIREBON;
    } else if (aCity.equalsIgnoreCase(GORONTALO)) {
      return ID_GORONTALO;
    } else if (aCity.equalsIgnoreCase(JAKARTA)) {
      return ID_JAKARTA;
    } else if (aCity.equalsIgnoreCase(JAMBI)) {
      return ID_JAMBI;
    } else if (aCity.equalsIgnoreCase(JAYAPURA)) {
      return ID_JAYAPURA;
    } else if (aCity.equalsIgnoreCase(KARAWANG)) {
      return ID_KARAWANG;
    } else if (aCity.equalsIgnoreCase(LAMPUNG)) {
      return ID_LAMPUNG;
    } else if (aCity.equalsIgnoreCase(MAKASSAR)) {
      return ID_MAKASSAR;
    } else if (aCity.equalsIgnoreCase(MALANG)) {
      return ID_MALANG;
    } else if (aCity.equalsIgnoreCase(MANADO)) {
      return ID_MANADO;
    } else if (aCity.equalsIgnoreCase(MATARAM)) {
      return ID_MATARAM;
    } else if (aCity.equalsIgnoreCase(MEDAN)) {
      return ID_MEDAN;
    } else if (aCity.equalsIgnoreCase(PADANG)) {
      return ID_PADANG;
    } else if (aCity.equalsIgnoreCase(PALANGKARAYA)) {
      return ID_PALANGKARAYA;
    } else if (aCity.equalsIgnoreCase(PALEMBANG)) {
      return ID_PALEMBANG;
    } else if (aCity.equalsIgnoreCase(PALU)) {
      return ID_PALU;
    } else if (aCity.equalsIgnoreCase(PEKANBARU)) {
      return ID_PEKANBARU;
    } else if (aCity.equalsIgnoreCase(PONTIANAK)) {
      return ID_PONTIANAK;
    } else if (aCity.equalsIgnoreCase(SAMARINDA)) {
      return ID_SAMARINDA;
    } else if (aCity.equalsIgnoreCase(SEMARANG)) {
      return ID_SEMARANG;
    } else if (aCity.equalsIgnoreCase(SINGKAWANG)) {
      return ID_SINGKAWANG;
    } else if (aCity.equalsIgnoreCase(SURABAYA)) {
      return ID_SURABAYA;
    } else if (aCity.equalsIgnoreCase(SURAKARTA)) {
      return ID_SURAKARTA;
    } else if (aCity.equalsIgnoreCase(TANGERANG)) {
      return ID_TANGERANG;
    } else if (aCity.equalsIgnoreCase(TASIKMALAYA)) {
      return ID_TASIKMALAYA;
    } else if (aCity.equalsIgnoreCase(YOGYAKARTA)) {
      return ID_YOGYAKARTA;
    } else {
      return null;
    }
  }
}
