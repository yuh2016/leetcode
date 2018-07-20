package com.codewars.yh;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecoder {
	
	
	public static String decode(String morseCode) {
		Map<String, String> MorseCode = new HashMap<>();
		MorseCode.put(".", "E");
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
		return Arrays.stream(morseCode.split("   ")).map(str -> {
			return Arrays.stream(str.split(" ")).map(chr -> MorseCode.get(chr) == null ? "" : MorseCode.get(chr)).collect(Collectors.joining());
		}).collect(Collectors.joining(" ")).trim();
    }
}
