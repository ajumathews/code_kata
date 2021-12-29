
function getSalesChartUrl(): string{
	if("prod" == process.env.CLOUD_ENVIRONMENT){
		if("eu-west-1" == process.env.EC2_REGION){
	       return "https://apps-eu.clarivate.com" ;
		}else{
		   return "https://apps.clarivate.com" ;
		} 
	} else{
	return "https://apps.dev-stable.clarivate.com" ;}
}


console.log(getSalesChartUrl());