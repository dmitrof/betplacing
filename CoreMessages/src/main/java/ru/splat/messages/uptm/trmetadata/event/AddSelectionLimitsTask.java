package ru.splat.messages.uptm.trmetadata.event;

import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;
import ru.splat.messages.uptm.trmetadata.LocalTask;

import java.util.Set;

/**
 * Created by Дмитрий on 17.12.2016.
 */
public class AddSelectionLimitsTask extends LocalTask {
    private final Set<Integer> selections;
    private final ServicesEnum service = ServicesEnum.EventService;

    public AddSelectionLimitsTask(
                                  Set<Integer> selections, Long time) {
        super(time);
        this.selections = selections;
    }


    @Override
    public TaskTypesEnum getType() {
        return TaskTypesEnum.ADD_SELECTION_LIMIT;
    }

    public ServicesEnum getService() {
        return service;
    }

    public Set<Integer> getSelections() {
        return selections;
    }


}
