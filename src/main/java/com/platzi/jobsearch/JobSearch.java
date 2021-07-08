package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.cli.CLIArguments;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        //Creation of our CLI with JCommander
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        //We get the options that were given to JCommander
        Stream<CLIArguments> streamOfCLI =
                //It returns an Optional <List <Object>>
                parseArguments(jCommander, args, JCommander::usage)
                        //In case of an Optional.empty ()
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        // We take our Stream and obtain the options that were given in the CLI
        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI
                        //We are only interested in cases where it is not the request for help
                        .filter(cli -> !cli.isHelp())
                        // And that contain a keyword, otherwise we don't have to search
                        .filter(cli -> cli.getKeyword() != null)
                        .findFirst();

        // If the Optional has a data, we convert it to Map <String, Object>
        cliArgumentsOptional.map(CLIFunctions::toMap)
                //We convert the Map into a request
                .map(JobSearch::executeRequest)
                // We are still operating on an Optional ... in case there was no data
                //We generate an empty stream
                .orElse(Stream.empty())
                //We print the data on the screen.
                .forEach(System.out::println);

    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {

    }
}
