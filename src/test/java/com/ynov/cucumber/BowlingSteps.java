package com.ynov.cucumber;

import com.ynov.BowlingScoreCalculation;
import com.ynov.Frame;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BowlingSteps {

    protected BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation();
    protected List<Frame> frames = new ArrayList<>();
    protected Integer score = 0;

    @Given("J'ai fait ce score lors de mon lancer : premier lancer : {int}, second lancer : {int}")
    public void j_ai_fait_ce_score_lors_de_mon_lancer(Integer firstLaunchScore, Integer secondLaunchScore) {
        frames = List.of(new Frame(firstLaunchScore, secondLaunchScore));
    }

    @Given("J'ai fait ces lancers")
    public void j_ai_fait_ces_lancers(DataTable table) {
        List<List<Integer>> framesInTest = table.asLists(Integer.class);

        for (List<Integer> frame : framesInTest) {
            if (frame.get(2) != 0) {
                frames.add(new Frame(frame.get(0), frame.get(1), frame.get(2)));
            } else {
                frames.add(new Frame(frame.get(0), frame.get(1)));
            }
        }

    }

    @When("Je calcule mon score")
    public void je_calcule_mon_score() {
        score = bowlingScoreCalculation.calculateScoreWithLaunch(frames);
    }

    @Then("J'ai un score de {int} points")
    public void j_ai_un_solde_de_euros(Integer scoreAttendu) {
        assertEquals(scoreAttendu, score);
    }
}
