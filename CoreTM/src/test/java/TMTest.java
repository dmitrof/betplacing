//import ru.splat.messages


import com.google.protobuf.Message;
import junit.framework.TestCase;
import ru.splat.messages.BetRequest;
import ru.splat.messages.Response;
import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;
import ru.splat.messages.uptm.trmetadata.*;
import ru.splat.messages.uptm.trmetadata.bet.AddBetTask;
import ru.splat.messages.uptm.trmetadata.bet.BetOutcome;
import ru.splat.messages.uptm.trmetadata.bet.FixBetTask;
import ru.splat.messages.uptm.trstate.ServiceResponse;
import ru.splat.tmprotobuf.ResponseParser;
import ru.splat.tmprotobuf.ResponseParserImpl;
import ru.splat.tmprotobuf.ProtobufFactory;
import ru.splat.tmprotobuf.ProtobufFactoryImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Дмитрий on 01.01.2017.
 */

public class TMTest extends TestCase {
    private Set<ServicesEnum> services;
    private Set<Integer> servicesOrd;
    private ProtobufFactory protobufFactory;
    private ResponseParser responseParser;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        services = new HashSet<>();
        services.add(ServicesEnum.BetService);
        services.add(ServicesEnum.EventService);
        services.add(ServicesEnum.BillingService);
        services.add(ServicesEnum.PunterService);
        servicesOrd = services.stream().map(Enum::ordinal)
                .collect(Collectors.toSet());

        protobufFactory = new ProtobufFactoryImpl();
        responseParser = new ResponseParserImpl();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public TMTest() {
        //addTestSuite(TMTest.class);
    }

    //работоспособность ProtobufFactoryImpl
    public void testBetProtobufP1() throws Exception {
        Set<BetOutcome> betOutcomes = new HashSet<>();
        //BetOutcome bo = new BetOutcome(1L, 2L, 3.14);
        betOutcomes.add(new BetOutcome(1, 2, 3.14));
        LocalTask bet1 = new AddBetTask(1, betOutcomes, System.currentTimeMillis());
        //buidling protobuf message
        BetRequest.Bet betMessage = (BetRequest.Bet) protobufFactory.buildProtobuf(bet1, services);
        //check punter id from generated message
        assertEquals(betMessage.getPunterId(), 1);
        Set<Integer> servicesOut = new HashSet<Integer>(betMessage.getServicesList());
        assertEquals(servicesOut, servicesOrd);

    }

    public void testBetProtobufP2() throws Exception{
        //test ProtobufFactoryImpl for second phase
        LocalTask bet1 = new FixBetTask(1L, System.currentTimeMillis());
        BetRequest.Bet betMessage = (BetRequest.Bet) protobufFactory.buildProtobuf(bet1, services);
        assertEquals(betMessage.getId(), 1L);
        assertTrue(betMessage.getBetOutcomeList().isEmpty());
    }
    //проверить после получения от кафки
    public void testResponseParser() {
        Message message = Response.ServiceResponse.newBuilder().addAllServices(servicesOrd)
               .setLongAttachment(100L).setResult(1).build();
        ServiceResponse<Long> serviceResponse = responseParser.unpackMessage(message);
        assertTrue(message instanceof Response.ServiceResponse);
        //assertEquals(serviceResponse.getAttachment(), 100L);
    }


}
