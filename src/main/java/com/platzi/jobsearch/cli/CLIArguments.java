package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    /**
     * Constructor default to allow only classes in the package, can create objets
     * from this class.
     * in this way we force the construction to be done through public functions o
     * builders.
     * <p>
     * Instances must be created using: CLIArguments#newInstance
     */
    CLIArguments() {
    }

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CLIKeywordValidator.class)
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "City, postal code or some other term to search for a location")
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "Each search contains 50 positions, you can page more results by changing the number, the page starts at 0")
    private int page = 0;

    @Parameter(
            names = "--full-time",
            description = "Add this flag if you only want to list 'full time' jobs"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = "--markdown",
            description = "Add this flag if you want to get the results in markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Show this help")
    private boolean help;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return help;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", pages=" + page +
                ", isFullTime=" + isFullTime +
                ", help=" + help +
                ", isMarkdown=" + isMarkdown +
                '}';
    }

    /**
     * This function is equivalent to CLIArguments :: new, however, if in the future we want to add
     * additional parameters, we can limit the way of constructing objects using this function.
     */
    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}