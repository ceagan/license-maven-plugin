package org.codehaus.mojo.license;

/*
 * #%L
 * License Maven Plugin
 * %%
 * Copyright (C) 2008 - 2012 CodeLutin, Codehaus, Tony Chemit
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

/**
 * The goal to update (or add) the header on project source files.
 * <p/>
 * This goal replace the {@code update-header} goal which can not deal with
 * Copyright.
 * <p/>
 * This goal use a specific project file descriptor {@code project.xml} to
 * describe all files to update for a whole project.
 *
 * @author tchemit <chemit@codelutin.com>
 * @requiresProject true
 * @goal update-file-header
 * @since 1.0
 */
public class UpdateFileHeaderMojo
    extends AbstractFileHeaderMojo
{

    /**
     * A flag to fail the build if {@link #dryRun} flag is on and some files with
     * no header are detected.
     * <p/>
     * <strong>Note:</strong> If {@link #dryRun} flag is not set, there is no effect.
     *
     * @parameter property="license.failOnMissingHeader" default-value="false"
     * @since 1.2
     */
    protected boolean failOnMissingHeader;

    /**
     * A flag to fail the build if {@link #dryRun} flag is on and some files with headers
     * to update.
     * <p/>
     * <strong>Note:</strong> If {@link #dryRun} flag is not set, there is no effect.
     *
     * @parameter property="license.failOnNotUptodateHeader" default-value="false"
     * @since 1.2
     */
    protected boolean failOnNotUptodateHeader;

    /**
     * A flag to skip the goal.
     *
     * @parameter property="license.skipUpdateLicense" default-value="false"
     * @since 1.0
     */
    protected boolean skipUpdateLicense;

    /**
     * A flag to test plugin but modify no file.
     *
     * @parameter property="dryRun" default-value="false"
     * @since 1.0
     */
    protected boolean dryRun;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSkip()
    {
        return skipUpdateLicense;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSkip( boolean skip )
    {
        this.skipUpdateLicense = skip;
    }

    @Override
    protected boolean isDryRun()
    {
        return dryRun;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isFailOnMissingHeader()
    {
        return failOnMissingHeader;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isFailOnNotUptodateHeader()
    {
        return failOnNotUptodateHeader;
    }

}
