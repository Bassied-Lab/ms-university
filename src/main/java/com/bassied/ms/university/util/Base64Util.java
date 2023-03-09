package com.bassied.ms.university.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Util {

    public static String encodeToString(String str) {
        return Base64.getUrlEncoder().encodeToString(str.getBytes());
    }

    public static byte[] decode(String base64Str) {
        return Base64.getUrlDecoder().decode(base64Str);
    }
}
