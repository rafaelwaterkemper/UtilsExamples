import java.time.Instant;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;

public class PrintTransition {

    public static void main(String args[]) {

        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        ZoneRules rules = zoneId.getRules();

        ZoneOffsetTransition nextTransition = rules.nextTransition(Instant.now());
        System.out.println("Next transition at: " +
                nextTransition.getInstant().atZone(zoneId));

        ZoneOffsetTransition nextNextTransition =
                rules.nextTransition(nextTransition.getInstant());
        System.out.println("Next transition after that at: " +
                nextNextTransition.getInstant().atZone(zoneId));
    }
}
