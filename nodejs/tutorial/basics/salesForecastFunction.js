function getSalesChartUrl() {
    console.log(process.env.CLOUD_ENVIRONMENT); // dev
    console.log(process.env.EC2_REGION); // eu-west-1
    console.log(process.env.CLOUD_DEV_PHASE); // snapshots
    if ("prod" == process.env.CLOUD_ENVIRONMENT) {
        if ("eu-west-1" == process.env.EC2_REGION) {
            return "https://apps-eu.clarivate.com";
        }
        else {
            return "https://apps.clarivate.com";
        }
    }
    else {
        return "https://apps.dev-stable.clarivate.com";
    }
}
console.log(getSalesChartUrl());
