#!/bin/bash

access_token=$(curl -d "client_id=p-service-registry-adbd21fe-0f92-4874-b233-2033ed71ac7a&\
client_secret=xbS88Tbhv0Xt&\
redirect_uri=https://eureka-35fc2b2d-996a-491b-8048-5a5f247a032c.local.pcfdev.io&\
grant_type=client_credentials" https://p-spring-cloud-services.uaa.local.pcfdev.io/oauth/token --silent | jq .access_token -r)

instid_json=$(curl -H "Authorization: Bearer $access_token" -H "Accept: application/json" "https://eureka-35fc2b2d-996a-491b-8048-5a5f247a032c.local.pcfdev.io/eureka/apps/DISCOVERY-BLUE-GREEN" --silent)
echo $instid_json | jq .
instid=$(echo $instid_json | jq '.application.instance[0].instanceId')
echo
echo
echo $instid_json | jq .
echo
echo

#curl -H "Authorization: Bearer $access_token" -H "Accept: application/json" "https://eureka-35fc2b2d-996a-491b-8048-5a5f247a032c.local.pcfdev.io/eureka/apps/DISCOVERY-BLUE-GREEN/$instid/status?value=UP" -v