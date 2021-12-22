package com.example.member.domain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA256 클래스.
 */
public class SHA256 {

  /**
   * 입력받은 String 값을 SHA256으로 암호화 합니다.
   *
   * @return 암호화된 문자열
   */
  public static String encrypt(final String text) throws NoSuchAlgorithmException {
    final MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(text.getBytes());

    return bytesToHex(md.digest());
  }

  private static String bytesToHex(final byte[] bytes) {
    final StringBuilder builder = new StringBuilder();
    for (final byte b : bytes) {
      builder.append(String.format("%02x", b));
    }
    return builder.toString();
  }

}
