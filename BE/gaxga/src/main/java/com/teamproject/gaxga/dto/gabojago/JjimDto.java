package com.teamproject.gaxga.dto.gabojago;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JjimDto {
        private Long userId;
        private String name;
        private Long gabojagoId;


        public JjimDto(Long userId, Long gabojagoId) {
            this.userId = userId;
            this.gabojagoId = gabojagoId;
        }
}
