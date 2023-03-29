package testRunnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features= {".//Features//"},
			//features= {".//Features//OrangeLoginDDTExcel.feature"},
			//features="@target/rerun.txt",
	        glue="stepDefinations",
	        plugin= {
	        		"pretty", "html:reports/myreport.html", 
	        		"json:reports/myreport.json",
	        		"rerun:target/rerun.txt",
	        		},    //Mandatory to capture failures
	        dryRun=false,  //to check corresponding step definationa are available or not but no execution
	        monochrome=true  //to avoid junk charecters in the console file
	        
	      //  tags = "@sanity and @Regression" //Scenarios tagged with @sanity,
	                  
	      )
	public class Runner {
			
			
			
			
			
			
			
			

}
