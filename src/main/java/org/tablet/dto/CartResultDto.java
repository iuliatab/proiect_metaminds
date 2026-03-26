package org.tablet.dto;

import java.util.List;

public record CartResultDto(String optionName, List<CartItemDto> items, double totalPrice) {
}