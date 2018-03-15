package org.hyl.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class InternalServerErrorException extends AbstractThrowableProblem {

    private static final URI TYPE = URI.create("https://example.org/internal-server-error");

    public InternalServerErrorException(String message) {
        super(TYPE, message, Status.INTERNAL_SERVER_ERROR);
    }
}
