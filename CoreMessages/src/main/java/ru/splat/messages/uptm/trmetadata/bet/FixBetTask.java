package ru.splat.messages.uptm.trmetadata.bet;

import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;
import ru.splat.messages.uptm.trmetadata.LocalTask;

/**
 * Created by Дмитрий on 04.02.2017.
 */
public class FixBetTask extends LocalTask {
    private final ServicesEnum service = ServicesEnum.BetService;
    private final Long betId;
    //конструктор второй фазы
    public FixBetTask(TaskTypesEnum type, Long betId, Long time) {
        super(type, time);
        this.betId = betId;

    }

    public Long getBetId() {
        return betId;
    }

    @Override
    public ServicesEnum getService() {
        return service;
    }


}