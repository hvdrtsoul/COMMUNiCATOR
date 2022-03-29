package com.example.communicator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMaster {

    private final int PRIME_MULT = 1717;

    private static String bytes_to_hex(byte[] hash) {
        StringBuilder hex_string = new StringBuilder(2 * hash.length);
        for(int i = 0;i < hash.length;++i)
        {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1)
            {
                hex_string.append('0');
            }
            hex_string.append(hex);
        }

        return hex_string.toString();
    }


    public String get_hash_sha256(String input) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] byte_hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        return bytes_to_hex(byte_hash);

    }

    public Integer get_simple_hash(String input)
    {
        return ((input.hashCode() * PRIME_MULT) << 3) % 17171717;
    }

}