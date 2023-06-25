package com.mikt.rockpaperscissors.dots;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RulesResponse {
    private Map<String, String> rulesMap;
}
