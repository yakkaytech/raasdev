<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Welcome to New Member</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
 
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<spring:url value="/resources/common/dummy/css/wizard.css" var="css2" />
<spring:url value="/resources/common/dummy/css/bootstrap-tagsinput.css" var="css1" />
<spring:url value="/resources/common/dummy/css/formelements.css" var="css7" />
<spring:url value="/resources/common/dummy/css/jquery.steps.css" var="css3" />
<spring:url value="/resources/common/dummy/js/wizard.css" var="css5" />
<spring:url value="/resources/common/dummy/css/select2.min.css" var="css4" />	
<spring:url value="/resources/common/dummy/js/bootstrap-tagsinput.min.js" var="js1" />		
<spring:url value="/resources/common/dummy/css/bootstrap-slider.min.css" var="css8" />				
<spring:url value="/resources/common/dummy/js/form_wizard.js" var="js2" />	
<spring:url value="/resources/common/dummy/js/select2.min.js" var="js6" />	
<spring:url value="/resources/common/dummy/js/jquery.steps.js" var="js4" />
<spring:url value="/resources/common/dummy/js/jasny-bootstrap.js" var="js3" />	
<spring:url value="/resources/common/dummy/js/moment.min.js" var="js7" />
<spring:url value="/resources/common/dummy/js/jquery.validate.min.js" var="js5" />	
	
 
<link href="${css2}" rel="stylesheet">
<link href="${css1}" rel="stylesheet">
<link href="${css7}" rel="stylesheet">
<link href="${css3}" rel="stylesheet">
<link href="${css5}" rel="stylesheet">
<link href="${css4}" rel="stylesheet">
<link href="${css8}" rel="stylesheet">

<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js6}"></script>
<script src="${js4}"></script>
<script src="${js3}"></script>
<script src="${js7}"></script>
<script src="${js5}"></script>

</head>
<div class="container">
<!--section ends-->
<section class="content">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="livicon" data-name="bell" data-size="16" data-loop="true" data-c="#fff" data-hc="white"></i>
                        New Member  
                    </h3>
                    <span class="pull-right clickable">
                        <i class="glyphicon glyphicon-chevron-up"></i>
                    </span>
                </div>
                <div class="panel-body">
                    <!--main content-->
                    <div class="row">
                        <div class="col-md-12">
                            <!-- BEGIN FORM WIZARD WITH VALIDATION -->
                            <form id="wizard-validation" action="#">
                                <h1 class="hidden-xs">What do you do? - Experience & Skillset</h1>
                               <section>
                                    <h2 class="hidden">&nbsp;</h2>
									<div class="form-group">
                                        <label for="description">Breif summary of your education & experience </label> 
                                        <textarea class="form-control" rows="4" id="description" name="textarea" placeholder="Breif summary of your education & experience" ></textarea>
                                     </div>
                                      <label for="Skillset">Enter Top 10 Skills</label> 
                                     <div class="form-group">
                                       <input type="text" value="PHP,Laravel,Spring Batch,HTML5,CSS" data-role="tagsinput" id="topskill" name="topskill"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="surname">Please select the role(s) that best fits your experience</label>
                                        <div>
                                            <table class="table table-striped table-bordered" id="table1">
                                                <thead>
                                                    <tr>
                                                        <th class="col-md-2 text-center">Select</th>
                                                        <th class="col-md-3">Role Name</th>
                                                        <th>Role Description</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="12"></td>
                                                        <td>Cloud Project Planner</td>
                                                        <td><p>Plan, organize and control the project tasks. Responsible for define the project roles, assign select resources, and assign tasks. Verify and sign-off once the task is complete.</p> </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="14"></td>
                                                        <td>Cloud Developer</td>
                                                        <td><p>View the task assignment with matching technology skills. Login and use the resources provided to them. Develops the application in the local and deploys to the cloud. Takes appropriate initative to gather necessary requirements and collaborate with the project owners ensuring successful delivery of the tasks.</p> </td>
                                                      </tr>
                                                       <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="23"></td>
                                                        <td>Cloud Developer (senior)</td>
                                                        <td><p>Advance experience using cloud technology including PaaS, SaaS and IaaS. Ability to design, development, test and deploy application using cloud. Takes appropriate initiative to gather necessary requirements and collobrate to the project owners ensuring successful delivery of the tasks.</p> </td>
                                                      </tr>
                                                       <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="33"></td>
                                                        <td>Cloud Architect</td>
                                                        <td><p>The cloud architect has demonstrated proficiency in the technical architecture that underlies cloud platform and cloud based IT resources and solutions, and has mastered the hands-on application of design patterns, principles, and practices used to engineer and evolve environments.</p> </td>
                                                      </tr>
                                                       <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="43"></td>
                                                        <td>Cloud Administrator</td>
                                                        <td><p>Manages the cloud infrastructure. Creates user accounts, provision cloud resources, manage and maintain the infrastructure, facilitates production deployment. </p> </td>
                                                      </tr>  
                                                      <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="13"></td>
                                                        <td>Cloud Database Developer</td>
                                                        <td><p>Responsible for developing database components. Have experience using appropriate cloud resources. </p> </td>
                                                      </tr>  
                                                      <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="53"></td>
                                                        <td>Cloud Database Administrator</td>
                                                        <td><p>Ability to manage cloud based database resources. Proficient in architecting, designing, developing and implementing applications using the cloud resources. </p> </td>
                                                      </tr>
                                                       <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="63"></td>
                                                       <td>UX designer</td>
                                                        <td><p>UX designer responsible for designing the user interfaces. </p> </td>
                                                      </tr> 
                                                      <tr>
                                                       <td class="col-md-2 text-center"><input type="checkbox" name="checkboxes" id="checkboxes-0" value="99"></td>
                                                       <td>
                                                        <label>Other</label>
                                                        <input type="text" value="" />
                                                        </td>
                                                        <td>
                                                           <textarea class="form-control" rows="2" id="description" name="textarea" placeholder="" >
                                                           </textarea>     
                                                        </td>
                                                      </tr>
                                                </tbody>
                                            </table>    
                                        </div>    

                                    </div>
                                    <p>(*) Mandatory</p>
                                </section>
                                <h1>Where do you work from?</h1>
                                <section>
                                    <div class="form-group">
                                    <label for="country">
                                   Please select the country where do you work:
                                    </label><br>
                                       <select name="countryval" id="select2_sample4">
                                         <option value="US">
                                            United States
                                        </option>
                                        <option value="AF">
                                            Afghanistan                     
                                        </option>
                                        <option value="AL">Albania</option>
                                        <option value="DZ">Algeria</option>
                                        <option value="AS">
                                            American Samoa
                                        </option>
                                        <option value="AD">Andorra</option>
                                        <option value="AO">Angola</option>
                                        <option value="AI">Anguilla</option>
                                        <option value="AQ">Antarctica</option>
                                        <option value="AR">Argentina</option>
                                        <option value="AM">Armenia</option>
                                        <option value="AW">Aruba</option>
                                        <option value="AU">Australia</option>
                                        <option value="AT">Austria</option>
                                        <option value="AZ">Azerbaijan</option>
                                        <option value="BS">Bahamas</option>
                                        <option value="BH">Bahrain</option>
                                        <option value="BD">Bangladesh</option>
                                        <option value="BB">Barbados</option>
                                        <option value="BY">Belarus</option>
                                        <option value="BE">Belgium</option>
                                        <option value="BZ">Belize</option>
                                        <option value="BJ">Benin</option>
                                        <option value="BM">Bermuda</option>
                                        <option value="BT">Bhutan</option>
                                        <option value="BO">Bolivia</option>
                                        <option value="BA">
                                            Bosnia and Herzegowina
                                        </option>
                                        <option value="BW">Botswana</option>
                                        <option value="BV">
                                            Bouvet Island
                                        </option>
                                        <option value="BR">Brazil</option>
                                        <option value="IO">
                                            British Indian Ocean Territory
                                        </option>
                                        <option value="BN">
                                            Brunei Darussalam
                                        </option>
                                        <option value="BG">Bulgaria</option>
                                        <option value="BF">
                                            Burkina Faso
                                        </option>
                                        <option value="BI">Burundi</option>
                                        <option value="KH">Cambodia</option>
                                        <option value="CM">Cameroon</option>
                                        <option value="CA">Canada</option>
                                        <option value="CV">Cape Verde</option>
                                        <option value="KY">
                                            Cayman Islands
                                        </option>
                                        <option value="CF">
                                            Central African Republic
                                        </option>
                                        <option value="TD">Chad</option>
                                        <option value="CL">Chile</option>
                                        <option value="CN">China</option>
                                        <option value="CX">
                                            Christmas Island
                                        </option>
                                        <option value="CC">
                                            Cocos (Keeling) Islands
                                        </option>
                                        <option value="CO">Colombia</option>
                                        <option value="KM">Comoros</option>
                                        <option value="CG">Congo</option>
                                        <option value="CD">
                                            Congo, the Democratic Republic of the
                                        </option>
                                        <option value="CK">
                                            Cook Islands
                                        </option>
                                        <option value="CR">Costa Rica</option>
                                        <option value="CI">
                                            Cote d'Ivoire
                                        </option>
                                        <option value="HR">
                                            Croatia (Hrvatska)
                                        </option>
                                        <option value="CU">Cuba</option>
                                        <option value="CY">Cyprus</option>
                                        <option value="CZ">
                                            Czech Republic
                                        </option>
                                        <option value="DK">Denmark</option>
                                        <option value="DJ">Djibouti</option>
                                        <option value="DM">Dominica</option>
                                        <option value="DO">
                                            Dominican Republic
                                        </option>
                                        <option value="EC">Ecuador</option>
                                        <option value="EG">Egypt</option>
                                        <option value="SV">
                                            El Salvador
                                        </option>
                                        <option value="GQ">
                                            Equatorial Guinea
                                        </option>
                                        <option value="ER">Eritrea</option>
                                        <option value="EE">Estonia</option>
                                        <option value="ET">Ethiopia</option>
                                        <option value="FK">
                                            Falkland Islands (Malvinas)
                                        </option>
                                        <option value="FO">
                                            Faroe Islands
                                        </option>
                                        <option value="FJ">Fiji</option>
                                        <option value="FI">Finland</option>
                                        <option value="FR">France</option>
                                        <option value="GF">
                                            French Guiana
                                        </option>
                                        <option value="PF">
                                            French Polynesia
                                        </option>
                                        <option value="TF">
                                            French Southern Territories
                                        </option>
                                        <option value="GA">Gabon</option>
                                        <option value="GM">Gambia</option>
                                        <option value="GE">Georgia</option>
                                        <option value="DE">Germany</option>
                                        <option value="GH">Ghana</option>
                                        <option value="GI">Gibraltar</option>
                                        <option value="GR">Greece</option>
                                        <option value="GL">Greenland</option>
                                        <option value="GD">Grenada</option>
                                        <option value="GP">Guadeloupe</option>
                                        <option value="GU">Guam</option>
                                        <option value="GT">Guatemala</option>
                                        <option value="GN">Guinea</option>
                                        <option value="GW">
                                            Guinea-Bissau
                                        </option>
                                        <option value="GY">Guyana</option>
                                        <option value="HT">Haiti</option>
                                        <option value="HM">
                                            Heard and Mc Donald Islands
                                        </option>
                                        <option value="VA">
                                            Holy See (Vatican City State)
                                        </option>
                                        <option value="HN">Honduras</option>
                                        <option value="HK">Hong Kong</option>
                                        <option value="HU">Hungary</option>
                                        <option value="IS">Iceland</option>
                                        <option value="IN">India</option>
                                        <option value="ID">Indonesia</option>
                                        <option value="IR">
                                            Iran (Islamic Republic of)
                                        </option>
                                        <option value="IQ">Iraq</option>
                                        <option value="IE">Ireland</option>
                                        <option value="IL">Israel</option>
                                        <option value="IT">Italy</option>
                                        <option value="JM">Jamaica</option>
                                        <option value="JP">Japan</option>
                                        <option value="JO">Jordan</option>
                                        <option value="KZ">Kazakhstan</option>
                                        <option value="KE">Kenya</option>
                                        <option value="KI">Kiribati</option>
                                        <option value="KP">
                                            Korea, Democratic People's Republic of
                                        </option>
                                        <option value="KR">
                                            Korea, Republic of
                                        </option>
                                        <option value="KW">Kuwait</option>
                                        <option value="KG">Kyrgyzstan</option>
                                        <option value="LA">
                                            Lao People's Democratic Republic
                                        </option>
                                        <option value="LV">Latvia</option>
                                        <option value="LB">Lebanon</option>
                                        <option value="LS">Lesotho</option>
                                        <option value="LR">Liberia</option>
                                        <option value="LY">
                                            Libyan Arab Jamahiriya
                                        </option>
                                        <option value="LI">
                                            Liechtenstein
                                        </option>
                                        <option value="LT">Lithuania</option>
                                        <option value="LU">Luxembourg</option>
                                        <option value="MO">Macau</option>
                                        <option value="MK">
                                            Macedonia, The Former Yugoslav Republic of
                                        </option>
                                        <option value="MG">Madagascar</option>
                                        <option value="MW">Malawi</option>
                                        <option value="MY">Malaysia</option>
                                        <option value="MV">Maldives</option>
                                        <option value="ML">Mali</option>
                                        <option value="MT">Malta</option>
                                        <option value="MH">
                                            Marshall Islands
                                        </option>
                                        <option value="MQ">Martinique</option>
                                        <option value="MR">Mauritania</option>
                                        <option value="MU">Mauritius</option>
                                        <option value="YT">Mayotte</option>
                                        <option value="MX">Mexico</option>
                                        <option value="FM">
                                            Micronesia, Federated States of
                                        </option>
                                        <option value="MD">
                                            Moldova, Republic of
                                        </option>
                                        <option value="MC">Monaco</option>
                                        <option value="MN">Mongolia</option>
                                        <option value="MS">Montserrat</option>
                                        <option value="MA">Morocco</option>
                                        <option value="MZ">Mozambique</option>
                                        <option value="MM">Myanmar</option>
                                        <option value="NA">Namibia</option>
                                        <option value="NR">Nauru</option>
                                        <option value="NP">Nepal</option>
                                        <option value="NL">
                                            Netherlands
                                        </option>
                                        <option value="AN">
                                            Netherlands Antilles
                                        </option>
                                        <option value="NC">
                                            New Caledonia
                                        </option>
                                        <option value="NZ">
                                            New Zealand
                                        </option>
                                        <option value="NI">Nicaragua</option>
                                        <option value="NE">Niger</option>
                                        <option value="NG">Nigeria</option>
                                        <option value="NU">Niue</option>
                                        <option value="NF">
                                            Norfolk Island
                                        </option>
                                        <option value="MP">
                                            Northern Mariana Islands
                                        </option>
                                        <option value="NO">Norway</option>
                                        <option value="OM">Oman</option>
                                        <option value="PK">Pakistan</option>
                                        <option value="PW">Palau</option>
                                        <option value="PA">Panama</option>
                                        <option value="PG">
                                            Papua New Guinea
                                        </option>
                                        <option value="PY">Paraguay</option>
                                        <option value="PE">Peru</option>
                                        <option value="PH">
                                            Philippines
                                        </option>
                                        <option value="PN">Pitcairn</option>
                                        <option value="PL">Poland</option>
                                        <option value="PT">Portugal</option>
                                        <option value="PR">
                                            Puerto Rico
                                        </option>
                                        <option value="QA">Qatar</option>
                                        <option value="RE">Reunion</option>
                                        <option value="RO">Romania</option>
                                        <option value="RU">
                                            Russian Federation
                                        </option>
                                        <option value="RW">Rwanda</option>
                                        <option value="KN">
                                            Saint Kitts and Nevis
                                        </option>
                                        <option value="LC">
                                            Saint LUCIA
                                        </option>
                                        <option value="VC">
                                            Saint Vincent and the Grenadines
                                        </option>
                                        <option value="WS">Samoa</option>
                                        <option value="SM">San Marino</option>
                                        <option value="ST">
                                            Sao Tome and Principe
                                        </option>
                                        <option value="SA">
                                            Saudi Arabia
                                        </option>
                                        <option value="SN">Senegal</option>
                                        <option value="SC">Seychelles</option>
                                        <option value="SL">
                                            Sierra Leone
                                        </option>
                                        <option value="SG">Singapore</option>
                                        <option value="SK">
                                            Slovakia (Slovak Republic)
                                        </option>
                                        <option value="SI">Slovenia</option>
                                        <option value="SB">
                                            Solomon Islands
                                        </option>
                                        <option value="SO">Somalia</option>
                                        <option value="ZA">
                                            South Africa
                                        </option>
                                        <option value="GS">
                                            South Georgia and the South Sandwich Islands
                                        </option>
                                        <option value="ES">Spain</option>
                                        <option value="LK">Sri Lanka</option>
                                        <option value="SH">St. Helena</option>
                                        <option value="PM">
                                            St. Pierre and Miquelon
                                        </option>
                                        <option value="SD">Sudan</option>
                                        <option value="SR">Suriname</option>
                                        <option value="SJ">
                                            Svalbard and Jan Mayen Islands
                                        </option>
                                        <option value="SZ">Swaziland</option>
                                        <option value="SE">Sweden</option>
                                        <option value="CH">
                                            Switzerland
                                        </option>
                                        <option value="SY">
                                            Syrian Arab Republic
                                        </option>
                                        <option value="TW">
                                            Taiwan, Province of China
                                        </option>
                                        <option value="TJ">Tajikistan</option>
                                        <option value="TZ">
                                            Tanzania, United Republic of
                                        </option>
                                        <option value="TH">Thailand</option>
                                        <option value="TG">Togo</option>
                                        <option value="TK">Tokelau</option>
                                        <option value="TO">Tonga</option>
                                        <option value="TT">
                                            Trinidad and Tobago
                                        </option>
                                        <option value="TN">Tunisia</option>
                                        <option value="TR">Turkey</option>
                                        <option value="TM">
                                            Turkmenistan
                                        </option>
                                        <option value="TC">
                                            Turks and Caicos Islands
                                        </option>
                                        <option value="TV">Tuvalu</option>
                                        <option value="UG">Uganda</option>
                                        <option value="UA">Ukraine</option>
                                        <option value="AE">
                                            United Arab Emirates
                                        </option>
                                        <option value="GB">
                                            United Kingdom
                                        </option>
                                        <option value="US">
                                            United States
                                        </option>
                                        <option value="UM">
                                            United States Minor Outlying Islands
                                        </option>
                                        <option value="UY">Uruguay</option>
                                        <option value="UZ">Uzbekistan</option>
                                        <option value="VU">Vanuatu</option>
                                        <option value="VE">Venezuela</option>
                                        <option value="VN">Viet Nam</option>
                                        <option value="VG">
                                            Virgin Islands (British)
                                        </option>
                                        <option value="VI">
                                            Virgin Islands (U.S.)
                                        </option>
                                        <option value="WF">
                                            Wallis and Futuna Islands
                                        </option>
                                        <option value="EH">
                                            Western Sahara
                                        </option>
                                        <option value="YE">Yemen</option>
                                        <option value="ZM">Zambia</option>
                                        <option value="ZW">Zimbabwe</option>
                                    </select>
                                </div>
                                 <div class="form-group">
                                    <label for="country">
                                   State/Zone:
                                    </label><br>
                                       <select name="" id="select2_sample4" >
                                         <option value="AL">
                                            Alabama
                                        </option>
                                        <option value="AK">
                                            Alaska                     
                                        </option>
                                        <option value="AZ">Arizona</option>
                                        <option value="AR">Arkansas</option>
                                        <option value="CA">
                                            California
                                        </option>
                                        <option value="CO">Colarado</option>
                                        <option value="CT">Connecticut</option>
                                        <option value="DE">Delaware</option>
                                        <option value="DC">District of Columbia</option>
                                       </select>
                                </div>        
                                <div class="form-group">
                                    <label for="country">
                                   Please select your timezone. This would help us to find work within your timezone:
                                    </label><br>
                                    <select name="" id="select2_sample6">
                            <option timeZoneId="1" gmtAdjustment="GMT-12:00" useDaylightTime="0" value="-12">(GMT-12:00) International Date Line West</option>
                            <option timeZoneId="2" gmtAdjustment="GMT-11:00" useDaylightTime="0" value="-11">(GMT-11:00) Midway Island, Samoa</option>
                            <option timeZoneId="3" gmtAdjustment="GMT-10:00" useDaylightTime="0" value="-10">(GMT-10:00) Hawaii</option>
                            <option timeZoneId="4" gmtAdjustment="GMT-09:00" useDaylightTime="1" value="-9">(GMT-09:00) Alaska</option>
                            <option timeZoneId="5" gmtAdjustment="GMT-08:00" useDaylightTime="1" value="-8">(GMT-08:00) Pacific Time (US & Canada)</option>
                            <option timeZoneId="6" gmtAdjustment="GMT-08:00" useDaylightTime="1" value="-8">(GMT-08:00) Tijuana, Baja California</option>
                            <option timeZoneId="7" gmtAdjustment="GMT-07:00" useDaylightTime="0" value="-7">(GMT-07:00) Arizona</option>
                            <option timeZoneId="8" gmtAdjustment="GMT-07:00" useDaylightTime="1" value="-7">(GMT-07:00) Chihuahua, La Paz, Mazatlan</option>
                            <option timeZoneId="9" gmtAdjustment="GMT-07:00" useDaylightTime="1" value="-7">(GMT-07:00) Mountain Time (US & Canada)</option>
                            <option timeZoneId="10" gmtAdjustment="GMT-06:00" useDaylightTime="0" value="-6">(GMT-06:00) Central America</option>
                            <option timeZoneId="11" gmtAdjustment="GMT-06:00" useDaylightTime="1" value="-6">(GMT-06:00) Central Time (US & Canada)</option>
                            <option timeZoneId="12" gmtAdjustment="GMT-06:00" useDaylightTime="1" value="-6">(GMT-06:00) Guadalajara, Mexico City, Monterrey</option>
                            <option timeZoneId="13" gmtAdjustment="GMT-06:00" useDaylightTime="0" value="-6">(GMT-06:00) Saskatchewan</option>
                            <option timeZoneId="14" gmtAdjustment="GMT-05:00" useDaylightTime="0" value="-5">(GMT-05:00) Bogota, Lima, Quito, Rio Branco</option>
                            <option timeZoneId="15" gmtAdjustment="GMT-05:00" useDaylightTime="1" value="-5">(GMT-05:00) Eastern Time (US & Canada)</option>
                            <option timeZoneId="16" gmtAdjustment="GMT-05:00" useDaylightTime="1" value="-5">(GMT-05:00) Indiana (East)</option>
                            <option timeZoneId="17" gmtAdjustment="GMT-04:00" useDaylightTime="1" value="-4">(GMT-04:00) Atlantic Time (Canada)</option>
                            <option timeZoneId="18" gmtAdjustment="GMT-04:00" useDaylightTime="0" value="-4">(GMT-04:00) Caracas, La Paz</option>
                            <option timeZoneId="19" gmtAdjustment="GMT-04:00" useDaylightTime="0" value="-4">(GMT-04:00) Manaus</option>
                            <option timeZoneId="20" gmtAdjustment="GMT-04:00" useDaylightTime="1" value="-4">(GMT-04:00) Santiago</option>
                            <option timeZoneId="21" gmtAdjustment="GMT-03:30" useDaylightTime="1" value="-3.5">(GMT-03:30) Newfoundland</option>
                            <option timeZoneId="22" gmtAdjustment="GMT-03:00" useDaylightTime="1" value="-3">(GMT-03:00) Brasilia</option>
                            <option timeZoneId="23" gmtAdjustment="GMT-03:00" useDaylightTime="0" value="-3">(GMT-03:00) Buenos Aires, Georgetown</option>
                            <option timeZoneId="24" gmtAdjustment="GMT-03:00" useDaylightTime="1" value="-3">(GMT-03:00) Greenland</option>
                            <option timeZoneId="25" gmtAdjustment="GMT-03:00" useDaylightTime="1" value="-3">(GMT-03:00) Montevideo</option>
                            <option timeZoneId="26" gmtAdjustment="GMT-02:00" useDaylightTime="1" value="-2">(GMT-02:00) Mid-Atlantic</option>
                            <option timeZoneId="27" gmtAdjustment="GMT-01:00" useDaylightTime="0" value="-1">(GMT-01:00) Cape Verde Is.</option>
                            <option timeZoneId="28" gmtAdjustment="GMT-01:00" useDaylightTime="1" value="-1">(GMT-01:00) Azores</option>
                            <option timeZoneId="29" gmtAdjustment="GMT+00:00" useDaylightTime="0" value="0">(GMT+00:00) Casablanca, Monrovia, Reykjavik</option>
                            <option timeZoneId="30" gmtAdjustment="GMT+00:00" useDaylightTime="1" value="0">(GMT+00:00) Greenwich Mean Time : Dublin, Edinburgh, Lisbon, London</option>
                            <option timeZoneId="31" gmtAdjustment="GMT+01:00" useDaylightTime="1" value="1">(GMT+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna</option>
                            <option timeZoneId="32" gmtAdjustment="GMT+01:00" useDaylightTime="1" value="1">(GMT+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague</option>
                            <option timeZoneId="33" gmtAdjustment="GMT+01:00" useDaylightTime="1" value="1">(GMT+01:00) Brussels, Copenhagen, Madrid, Paris</option>
                            <option timeZoneId="34" gmtAdjustment="GMT+01:00" useDaylightTime="1" value="1">(GMT+01:00) Sarajevo, Skopje, Warsaw, Zagreb</option>
                            <option timeZoneId="35" gmtAdjustment="GMT+01:00" useDaylightTime="1" value="1">(GMT+01:00) West Central Africa</option>
                            <option timeZoneId="36" gmtAdjustment="GMT+02:00" useDaylightTime="1" value="2">(GMT+02:00) Amman</option>
                            <option timeZoneId="37" gmtAdjustment="GMT+02:00" useDaylightTime="1" value="2">(GMT+02:00) Athens, Bucharest, Istanbul</option>
                            <option timeZoneId="38" gmtAdjustment="GMT+02:00" useDaylightTime="1" value="2">(GMT+02:00) Beirut</option>
                            <option timeZoneId="39" gmtAdjustment="GMT+02:00" useDaylightTime="1" value="2">(GMT+02:00) Cairo</option>
                            <option timeZoneId="40" gmtAdjustment="GMT+02:00" useDaylightTime="0" value="2">(GMT+02:00) Harare, Pretoria</option>
                            <option timeZoneId="41" gmtAdjustment="GMT+02:00" useDaylightTime="1" value="2">(GMT+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius</option>
                            <option timeZoneId="42" gmtAdjustment="GMT+02:00" useDaylightTime="1" value="2">(GMT+02:00) Jerusalem</option>
                        </select>
                    </div>
                      </section>
                                <h1>Rate & Availability</h1>
                              <section>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Rate per hour ($):</label><br>
                                            <div>
                                                <input id="ex6" type="text" name="Hourtextbox"/>
                                            </div>
                                    </div>
                                   <div class="form-group">
                                        <label class="col-md-2 control-label">Weekly Availability - expected work per week</label><br>
                                           <select name="countryval" id="select2_sample7">
                                                 <option></option>
                                                <option>4 hr </option>
                                                <option>5 hr </option>
                                                <option>6 hr </option>
                                                <option>7 hr </option>
                                                <option>8 hr </option>
                                                <option>9 hr </option>
                                                <option>10 hr </option>
                                                <option>11 hr </option>
                                                <option>12 hr </option>
                                                <option>13 hr </option>
                                                <option>14 hr </option>
                                                <option>15 hr </option>
                                                <option>16 hr </option>
                                                <option>17 hr </option>
                                                <option>18 hr </option>
                                                <option>19 hr </option>
                                                <option>20 hr </option>
                                                <option>21 hr </option>
                                                <option>22 hr </option>
                                                <option>23 hr </option>
                                                <option>24 hr </option>
                                                <option>25 hr </option>
                                                <option>26 hr </option>
                                                <option>27 hr </option>
                                                <option>28 hr </option>
                                                <option>29 hr </option>
                                                <option>30 hr </option>
                                                <option>31 hr </option>
                                                <option>32 hr </option>
                                                <option>33 hr </option>
                                                <option>34 hr </option>
                                                <option>35 hr </option>
                                                <option>36 hr </option>
                                                <option>37 hr </option>
                                                <option>38 hr </option>
                                                <option>39 hr </option>
                                                <option>40 hr </option>
                                           </select> 
                                    </div>
                                    <div class="form-group">
                                    <label></label> <br>
                                    <div class="pos-rel p-l-30">
                                        <input id="acceptTerms" name="acceptTerms" type="checkbox" class="pos-rel p-l-30 required">
                                        <label for="acceptTerms">I agree with the Terms and Conditions.</label>
                                    </div>
                                   </div>  
                                   
                                                            
                                </section>
                            </form>
                            <!-- END FORM WIZARD WITH VALIDATION --> 
                        </div>
                    </div>
                    <!--main content end--> 
                </div>
                
 
                
            </div>
        </div>
    </div>
</section>
<!-- content -->
  <!-- //Content Section End -->
    </div>
</html>