package com.mikt.rockpaperscissors.dots;

import com.mikt.rockpaperscissors.models.HandType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayRequest {
    private HandType hand;
}
