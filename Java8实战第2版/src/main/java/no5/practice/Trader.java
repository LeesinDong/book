package no5.practice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
@Data
@Builder
@AllArgsConstructor
public class Trader {
    private final String name;
    private final String city;

}
