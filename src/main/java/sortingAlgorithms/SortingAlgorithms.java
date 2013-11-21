package sortingAlgorithms;

import sortingAlgorithms.experiment.AppExperiment;
import sortingAlgorithms.experiment.impl.Experiment;

import java.util.Map;

/**
 * Main Class
 */
public class SortingAlgorithms {

    public static void main(String[] args) throws InterruptedException {

        AppExperiment appExperiment = new Experiment();

        int[] settings = appExperiment.getSettingsForExperiment();

        Map<String, Long> result = appExperiment.startExperiment(settings[0], settings[1],
                settings[2], null);

        appExperiment.showResultsOfExperiment(result);
    }
}
