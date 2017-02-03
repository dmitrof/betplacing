//import ru.splat.messages


import com.google.protobuf.Message;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import junit.runner.BaseTestRunner;
import org.junit.runner.RunWith;
import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;
import ru.splat.messages.uptm.trmetadata.*;
import ru.splat.messages.uptm.trstate.*;
import ru.splat.protobuf.ProtobufFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Дмитрий on 01.01.2017.
 */

public class TMTest extends TestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public TMTest() {
        //addTestSuite(TMTest.class);
    }

    //работоспособность ProtobufFactory
    public void testProtobuf() throws Exception {
        List<ServicesEnum> services = new LinkedList<>();
        services.add(ServicesEnum.BetService);
        List<BetOutcome> betOutcomes = new LinkedList<>();
        //BetOutcome bo = new BetOutcome(1L, 2L, 3.14);
        betOutcomes.add(new BetOutcome(1L, 2L, 3.14));
        LocalTask bet1 = new BetTask(TaskTypesEnum.ADD_BET, 1, betOutcomes);
        //buidling protobuf message
        Message message = ProtobufFactory.buildProtobuf(bet1, services);

        //LocalTask event = new EventTask(TaskTypesEnum.CHECK_EVENT_LIMIT);
    }

}
