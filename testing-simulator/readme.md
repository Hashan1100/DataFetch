# Simulator Guide

This simulator is developed using Wiremock stand alone module. Use star-sim.sh to start the simulator.

For more information regarding request mapping refer the wiremock guide at http://wiremock.org/stubbing.html#stubbing

## Request response mapping

Requests to be mapped are defined under *mappings* folder. If you want to add new mapping just add new `json` file inside mappings folder.
Responses for each request is kept in *__files/resps* folder.