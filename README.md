PAF form filler
================

[![Build status](https://travis-ci.org/KentCommunications/paf-filler.svg)](https://travis-ci.org/KentCommunications/paf-filler)
[![Coverage Status](https://img.shields.io/coveralls/KentCommunications/paf-filler.svg)](https://coveralls.io/r/KentCommunications/paf-filler?branch=master)
[![Coverity Scan Status](https://scan.coverity.com/projects/3553/badge.svg)](https://scan.coverity.com/projects/3553)


Prerequisites
-------------

  - [Oracle Java 8 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  installed and properly configured.
  - A [Free GitHub Account](https://github.com/signup/free).

Preparing to Hack
-----------------

Once you have [JDK 8](https://www.oracle.com/technetwork/java/javase/overview/index.html) installed,
you should clone this repo into your favorite working directory.

#### Clone

    cd <working directory>
    git clone git@github.com:KentCommunications/paf-filler.git
    cd paf-filler

Next we should make sure [Gradle](https://www.gradle.org/) is working.

#### Gradle

We have included the Gradle Wrapper in our project, to help make it easier for everyone.
All you need to do in order to make sure Gradle is working properly is run gradlew
(gradlew.bat for windows users):

    ./gradlew assemble

this should have output which looks similar to this:

    :compileJava
    :processResources
    :classes
    :jar
    :assemble

    BUILD SUCCESSFUL

    Total time: 0.06 secs

If you get an error, your JDK is probably incorrectly configured.

#### System Setup

In order for this program to work, it relies on a handful of environment variables

    BCC_API_KEY
	BCC_USERNAME
	BCC_PASSWORD
	
please define these variables for your needs prior to running the program.

#### Testing

Lastly, we need to make sure the test suite runs as expected. we use gradle here too, just run:

    ./gradlew test

If everything passes, you are ready to begin hacking.

Hacking
-------

There isn't much here right now, so I would suggest just sitting back and relaxing.
once we have a little more done, we will cover how to contribute in more detail.

Contributing
------------

Be sure to read the [CONTRIBUTING.md](https://github.com/KyleChamberlin/paf-filler/blob/master/CONTRIBUTING.md)
document in this repository for further information about how to contribute to this project.

Before you contribute you will also need to sign our [CLA](https://www.clahub.com/agreements/KyleChamberlin/paf-filler)
which is hosted by [CLAHub](https://www.clahub.com/).

Copyright
---------

Copyright 2014 Kent Communications

License
-------

*Licensed under the __Apache License__, Version __2.0__ (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at*

[Apache.org - Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

*Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an __"AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND__, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*
