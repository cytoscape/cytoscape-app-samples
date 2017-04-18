Cytoscape 3 App Developers: Samples and Template
================================================
This is a repository of code samples for Cytoscape 3 app developers. Fork and clone the repo to create your own custom samples to reference as you develop your own Cytoscape apps. This repo is also associated with the [Cytoscape App Developer Ladder](http://wiki.cytoscape.org/Cytoscape_3/AppDeveloper/Cytoscape_App_Ladder), which steps through all you need to know to develop, release and update your own Cytoscape apps.

Four examples that used an outdated architecture have been removed.  All samples now have a CyActivator object.

Samples
-------

Navigate to the directory containing the pom.xml for a
given sample, and run 'mvn install'. A new .jar file will be generated
in the target directory. You can install this .jar from within Cytoscape 3 using the
App Manager > Install From File.

Template
--------

This repo also includes a *project-template* directory, where you can start you own tutorial or original app projects.
