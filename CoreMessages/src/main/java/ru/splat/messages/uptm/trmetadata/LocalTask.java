package ru.splat.messages.uptm.trmetadata;

import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;

/**
 * Created by Дмитрий on 11.12.2016.
 */
//инкапсулирует одну из локальных операций транзакции
public abstract class LocalTask {
    private final TaskTypesEnum type; //тип локальной транзакции
    private final Long time;

    public LocalTask(TaskTypesEnum type, Long time) {
        this.type = type;
        this.time = time;
    }



    public TaskTypesEnum getType() {
        return type;
    }
    public abstract ServicesEnum getService();
}