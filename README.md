Selenium-xml-black-box-testscript
=================================

Selenium xml black box testscript

1.In this testcases are return in xml file 

2.we need to specify the actions and it's values in the xml file


Attributes in xml file In testcases xml file

1.Actions
        Need to specify the actions need to be performed ,available actions are "click,textfield,visibletext,select,submit"
        
        action="click"
        
2.element_type
        Need to specify the type of the element
        
        element_type="link"
        
3.element_location
        Need to specify the Xpath of the element need to click
        
        element_location=" //td[text()='19']"
       
4.element_name 
        Now it's empty
        
        element_name=""
      
5.data_input
        Need to specify the input value for textfield
        
        data_input="55555"
      
6.expected_result
        Need to specify the text that you need to verify wether it's available or not
        
        expected_result="Account Information"
      
7.waittime_ms
        Need to specify the waiting time before the actions to be performed
        
        waittime_ms="100"


Types of actions and it's purpose

  a.Action "click" is used to click some field
  
        this actions mandatory attributes are "action,element_type,element_location"
                     optional attributes is "waittime_ms"
  
       action="click"
   
  b.Action "textfield" is used to click the text field and type the value in the field
  
         this actions mandatory attributes are "action,element_type,element_location,data_input"
                     optional attributes is "waittime_ms"
                     
         action= "textfield"
  
  c.Action "select" is used to select the value from dropdown list
  
         this actions mandatory attributes are "action,element_type,element_location,data_input"
                     optional attributes is "waittime_ms"
                     
         action= "select"
       
  d.Action "visibletext" is used to veify the expected text and actual text are same
  
         this actions mandatory attributes are "action,element_type,expected_result"
                     optional attributes is "waittime_ms"
                     
         action= "visibletext"
       
   e.Action "submit" is used to submit the application forms
  
         this actions mandatory attributes are "action,element_type"
                     optional attributes is "waittime_ms"
                     
         action= "submit"
       
       
       
Sampletestcases xml file below

<?xml version="1.0" encoding="UTF-8"?>

<teststeps>
	<step action="click" element_type="link" element_location="MyAccount" element_name="" data_input=""  expected_result="" waittime_ms="100"  />
	<step action= "click" element_type="link" element_location="CreateAccount" element_name="" data_input="" expected_result="" waittime_ms="1000"/>
	<step action= "textfield" element_type="textbox" element_location="FirstName" element_name="" data_input="Sam" expected_result="" waittime_ms="500"/>
	<step action= "textfield" element_type="textbox" element_location="LastName" element_name="" data_input="son" expected_result="" waittime_ms=""/>
	<step action= "textfield" element_type="textbox" element_location="EmailName" element_name="" data_input="Samson@gmail.com" expected_result="" waittime_ms="" />
	<step action= "textfield" element_type="textbox" element_location="ReEmailName" element_name="" data_input="Samson@gmail.com" expected_result="" waittime_ms="" />
	<step action= "textfield" element_type="textbox" element_location="Password" element_name="" data_input="Samson123" expected_result="" waittime_ms=""/>
	<step action= "textfield" element_type="textbox" element_location="RePassword" element_name="" data_input="Samson123" expected_result="" waittime_ms=""/>
	<step action= "textfield" element_type="textbox" element_location="ZipCode" element_name="" data_input="55555" expected_result="" waittime_ms=""/>
	<step action= "click" element_type="button" element_location="Continue" element_name="" data_input="" expected_result="" waittime_ms=""/>
	<step action= "visibletext" element_type="text" element_location="" element_name="" data_input="" expected_result="Account Information" waittime_ms=""/>
</teststeps>



