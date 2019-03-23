package com.antmog.vk.bot.model.command.group;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupCommandParams {
    private int ownerId;
    private int count;
    private int offset;
}
