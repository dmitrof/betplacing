package ru.splat.messages.uptm.trmetadata.punter;

import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;
import ru.splat.messages.uptm.trmetadata.LocalTask;

/**
 * Created by Дмитрий on 17.12.2016.
 */
public class AddPunterLimitsTask extends LocalTask {
    private final Integer punterId;
    private final ServicesEnum service = ServicesEnum.PunterService;
    public AddPunterLimitsTask(TaskTypesEnum type, Integer _punterId, Long time) {
        super(type, time);
        this.punterId = _punterId;
    }

    @Override
    public ServicesEnum getService() {
        return service;
    }

    public Integer getPunterId() {
        return punterId;

    }
}
