package com.example.member.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.util.ResourceUtils;

public class ResourceMockUtil {

  public static String getString(final String fileName) {
    try (final FileInputStream fileInputStream = new FileInputStream(getFile(fileName))) {
      final StringBuilder sb = new StringBuilder();
      final byte[] buffer = new byte[100];
      int readSize;
      while ((readSize = fileInputStream.read(buffer)) != -1) {
        final byte[] copied = new byte[readSize];
        System.arraycopy(buffer, 0, copied, 0, readSize);
        sb.append(new String(copied));
      }
      fileInputStream.close();
      return sb.toString();
    } catch (final IOException e) {
      throw new AssertionError(e.getMessage());
    }
  }

  public static File getFile(final String fileName) {
    try {
      return ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "mock/" + fileName);
    } catch (final FileNotFoundException e) {
      throw new AssertionError(e.getMessage());
    }
  }

  public static FileInputStream getFileInputStream(final String fileName) {
    try {
      return new FileInputStream(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "mock/" + fileName));
    } catch (final FileNotFoundException e) {
      throw new AssertionError(e.getMessage());
    }
  }

}
