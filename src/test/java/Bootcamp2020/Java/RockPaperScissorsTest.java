package Bootcamp2020.Java;

import org.junit.Assert;
import org.junit.Test;

public class RockPaperScissorsTest {

    RockPaperScissors rockPaperScissors = new RockPaperScissors();

    @Test
    public void RockPaperScissors_shouldReturn_draw_if_bothDecisions_areEqual(){
        String expected = "Unentschieden";
        String actual = rockPaperScissors.compareDecisions("Stein", "Stein");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RockPaperScissors_shouldReturn_Player_1_if_p1_scissors_and_p2_paper(){
        String expected = "Spieler 1";
        String actual = rockPaperScissors.compareDecisions("Schere", "Papier");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RockPaperScissors_shouldReturn_Player_2_if_p1_scissors_and_p2_rock(){
        String expected = "Spieler 2";
        String actual = rockPaperScissors.compareDecisions("Schere", "Stein");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RockPaperScissors_shouldReturn_Player_1_if_p1_rock_and_p2_scissors(){
        String expected = "Spieler 1";
        String actual = rockPaperScissors.compareDecisions("Stein", "Schere");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RockPaperScissors_shouldReturn_Player_2_if_p1_rock_and_p2_paper(){
        String expected = "Spieler 2";
        String actual = rockPaperScissors.compareDecisions("Stein", "Papier");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RockPaperScissors_shouldReturn_Player_1_if_p1_paper_and_p2_rock(){
        String expected = "Spieler 1";
        String actual = rockPaperScissors.compareDecisions("Papier", "Stein");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RockPaperScissors_shouldReturn_Player_2_if_p1_paper_and_p2_scissors(){
        String expected = "Spieler 2";
        String actual = rockPaperScissors.compareDecisions("Papier", "Schere");
        Assert.assertEquals(expected, actual);
    }
}
