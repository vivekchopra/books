package com.wrox.begjsp.ch27.struts;

import org.apache.struts.action.ActionMapping;


/**
 * Implementation of ActionMapping. This defines the following custom properties:
 * <ul>
 * <li><b>failure</b> - The context-relative URI to which this request
 *     should be forwarded if a validation error occurs on the input
 *     information (typically goes back to the input form).
 * <li><b>success</b> - The context-relative URI to which this request
 *     should be forwarded if the requested action is successfully
 *     completed.
 * </ul>
 */
public final class ApplicationMapping extends ActionMapping
{
    /**
     * The failure URI for this mapping.
     */
    private String failure = null;

    /**
     * The success URI for this mapping.
     */
    private String success = null;

    /**
     * Return the failure URI for this mapping.
     */
    public String getFailure()
    {
        return (this.failure);
    }

    /**
     * Set the failure URI for this mapping.
     *
     * @param failure The failure URI for this mapping
     */
    public void setFailure(String failure)
    {
        this.failure = failure;
    }

    /**
     * Return the success URI for this mapping.
     */
    public String getSuccess()
    {
        return (this.success);
    }

    /**
     * Set the success URI for this mapping.
     *
     * @param success The success URI for this mapping
     */
    public void setSuccess(String success)
    {
        this.success = success;
    }
}
