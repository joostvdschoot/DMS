<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>DMS-DOM</title>
</head>
<body>
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
            <li class="dropdown-item"><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
            <li class="dropdown-item"><a href="#">App version:
                <g:meta name="info.app.version"/></a>
            </li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Grails version:
                <g:meta name="info.app.grailsVersion"/></a>
            </li>
            <li class="dropdown-item"><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
            <li class="dropdown-item"><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
            <li class="dropdown-item"><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                <li class="dropdown-item"><a href="#">${plugin.name} - ${plugin.version}</a></li>
            </g:each>
        </ul>
    </li>
</content>
<!--
-->
<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="ODS.png" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Object Data Store</h1>

        <p>
            The Object Data Store (ODS) contains configurations for the BeLux DMS Solution, and actual Objects (Contracts and Fines) and Memo's 
        </p>
        <br><br>

        <div id="controllers" role="navigation">
            <br>
            <h2>ODS Users:</h2>
            <ul>
            <li><g:link controller="User">Users (User)</g:link></li>
            <li><g:link controller="Role">Roles (Role)</g:link></li>
            <li><g:link controller="Userrole">Roles per User (Userrole)</g:link></li>
            </ul>

            <h2>Database:</h2>
            <ul>
            <li><a href="/h2-console" target="_blank" rel="noopener noreferrer">Database</a></li>
            </ul>


            <h2>Organization data:</h2>
            <ul>
            <li><g:link controller="Country">Countries (Country)</g:link></li>
            <li><g:link controller="Entity">Entities (Entity)</g:link></li>
            </ul>

            <h2>Active Directory:</h2>
            <ul>
            <li><g:link controller="Adgroup">AD Groups (Adgroup)</g:link></li>
            </ul>
    
            <h2>ODM Configuration:</h2>
            <ul>
            <li><g:link controller="Workspace">ODM Workspaces (Workspace)</g:link></li>
            <li><g:link controller="Folder">ODM Folders (Folder)</g:link></li>
            <li><g:link controller="Wsfolder">Folders per Workspace (Wsfolder)</g:link></li>
            <li><g:link controller="Doctype">ODM Document types (Doctype)</g:link></li>
            <li><g:link controller="Doccodeodm">Mapping Document Codes <=> ODM (Doccodeodm)</g:link></li>
            </ul>

            <h2>Document & Groups Configuration:</h2>
            <ul>
            <li><g:link controller="Doccode">Document Codes (Doccode)</g:link></li>
            <li><g:link controller="Docgroup">Document Groups (Docgroup)</g:link></li>
            <li><g:link controller="Docgroupstruct">Document Codes per Document Group (Docgroupstruct)</g:link></li>
            </ul>

            <h2>Save2Portal (s2p) Configuration:</h2>
            <ul>
            <li><g:link controller="Department">Departments (Department)</g:link></li>
            <li><g:link controller="S2ptabs">Tabs (S2ptabs)</g:link></li>
            <li><g:link controller="S2pstruct">Tabs <-> Document Groups (S2pstruct)</g:link></li>
            </ul>

            <h2>Search Page (sp) Configuration:</h2>
            <ul>
            <li><g:link controller="Sptabs">Tabs (Sptabs)</g:link></li>
            <li><g:link controller="Spsubtabs">Subtabs (Spsubtabs)</g:link></li>
            <li><g:link controller="Spsubtabsws">Subtabs-Workspace (Spsubtabsws)</g:link></li>
            <li><g:link controller="Spadws">AD-Workspace (Spadws)</g:link></li>
            <li><g:link controller="Spadwsgroup">AD-Workspace Group (Spadwsgroup)</g:link></li>
            </ul>

            <h2>Asset Related (Ar) Invoices Configuration:</h2>
            <ul>
            <li><g:link controller="Ardepartments">Departments (Ardepartments)</g:link></li>
            <li><g:link controller="Subcategory">Subcategories (Subcategory)</g:link></li>
            </ul>

            <h2>Objects & Memos</h2>
            <ul>
            <li><g:link controller="Object">Objects (Object)</g:link></li>
            <li><g:link controller="Memo">Memos (Memo)</g:link></li>
            </ul>

            <h2>All Controllers:</h2>
            <br>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                    </li>
                </g:each>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
