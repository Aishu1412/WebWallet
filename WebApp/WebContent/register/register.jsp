
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2{padding-left:20px}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">

	<h2>User Register Form</h2>
	<div class="col-md-6 col-md-offset-3">
			<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>
			
				<form action="<%=request.getContextPath()%>/RegisterController" method="post">

					<div class="form-group">
            <label for="full_name">Full Name</label> 
			<input type="text" name="full_name" placeholder="Full Name"/>
			</div>
			
			<div class="form-group">
			<label for="gender">Gender</label><br>
			<input type="radio" id="male" name="gender" value="male">
			<label for="male">Male</label><br>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">Female</label><br>
			</div>
			
			<div class="form-group">
			<label for="dob">DOB</label> 
			<input type="date" name="dob"/>
			</div>
			
			<div class="form-group">
			<label for="aadhar_number">Aadhaar Number</label> 
			<input type="text" name="aadhar_number" placeholder="Aadhaar Number"/>
			</div>
			
			<div class="form-group">
		    <label for="mobile_number">Mobile number</label> 
			<input type="text" name="mobile_number" placeholder="Mobile Number"/>
			</div>
			
			<div class="form-group">
			<label for="email_id">Email ID</label> 
			<input type="text" name="email_id" placeholder="Email ID"/>
			</div>
			
			<div class="form-group">
			<label for="address">Address</label> 
			<input type="text" name="address" placeholder="Address"/>
			</div>
			
			<div class="form-group">
			<label for="vehicle_number">Vehicle Number</label> 
			<input type="text" name="vehicle_number" placeholder="Vehicle Number"/><br>
			</div>
			
			<div class="form-group">
			<label for="vin">VIN</label> 
			<input type="text" name="vin" placeholder="VIN"/><br>
			</div>
			
			<div class="form-group">
			<label for="vehcile_class">Vehicle Class</label>
            <select name="vehcile_class" id="vehcile_class">
            <option value="MC 50CC (Motorcycle 50cc)">MC 50CC (Motorcycle 50cc)</option>
            <option value="MC EX50CC (Motorcycle more than 50cc)">MC EX50CC (Motorcycle more than 50cc)</option>
            <option value="MC Without Gear or M/CYCL.WOG (Motorcycle Without Gear)">MC Without Gear or M/CYCL.WOG (Motorcycle Without Gear)</option>
            <option value="MCWG or MC With Gear or M/CYCL.WG (Motorcycle With Gear)">MCWG or MC With Gear or M/CYCL.WG (Motorcycle With Gear)</option>
            <option value="LMV-NT (Light Motor Vehicle Non Transport)">LMV-NT (Light Motor Vehicle Non Transport)</option>
            <option value="LMV-INVCRG-NT (Light Motor Vehicle Invalid Carrige-Non Transport)">LMV-INVCRG-NT (Light Motor Vehicle Invalid Carrige-Non Transport)</option>
            <option value="LMV-TR (Light Motor Vehicle Transport)">LMV-TR (Light Motor Vehicle Transport)</option>
            <option value="LMV (Light Motor Vehicle)">LMV (Light Motor Vehicle)</option>
            <option value="LDRXCV (Loader, Excavator, Hydraulic Equipment)">LDRXCV (Loader, Excavator, Hydraulic Equipment)</option>
            <option value="HMV (Heavy Motor Vehicle)">HMV (Heavy Motor Vehicle)</option>
            <option value="HPMV (Heavy Passenger Motor Vehicle)">HPMV (Heavy Passenger Motor Vehicle)</option>
            <option value="HTV">HTV</option>
            <option value="TRANS (Heavy Goods Motor Vehicle, Heavy Passenger Motor Vehicle)">TRANS (Heavy Goods Motor Vehicle, Heavy Passenger Motor Vehicle)</option>
            </select>
            </div>
			
			<div class="form-group">
			<label for="fname">Fuel</label> 
			<input type="radio" id="petrol" name="fuel" value="petrol">
            <label for="petrol">Petrol</label><br>
            <input type="radio" id="diesel" name="fuel" value="diesel">
            <label for="diesel">Diesel</label><br>
           </div>
			
			<div class="form-group">
			<label for="register_authority">Register Auhtority</label>
            <select name="register_authority" id="register_authority">
            <option value="RTO,CHENNAI (CENTRAL-TN01)">RTO,CHENNAI (CENTRAL-TN01)</option>
            <option value="RTO,CHENNAI(NORT WEST-TN02)">RTO,CHENNAI(NORT WEST-TN02)</option>
            <option value="RTO,CHENNAI(NORTH EAST-TN03)">RTO,CHENNAI(NORTH EAST-TN03)</option>
            <option value="RTO,CHENNAI (EAST-TN04)">RTO,CHENNAI (EAST-TN04)</option>
            <option value="REGIONAL TRANSPORT OFFICE, CHENNAI (NORTH-	TN05)">REGIONAL TRANSPORT OFFICE, CHENNAI (NORTH-	TN05)</option>
            <option value="RTO CHENNAI(SOUTH-EAST-TN06)">RTO CHENNAI(SOUTH-EAST-TN06)</option>
            <option value="RTO CHENNAI(SOUTH-TN07)">RTO CHENNAI(SOUTH-TN07)</option>
            <option value="RTO CHENNAI (WEST-TN09)">RTO CHENNAI (WEST-TN09)</option>
            <option value="RTO CHENNAI(SOUTH-WEST-TN10)">RTO CHENNAI(SOUTH-WEST-TN10)</option>
            </select>
			</div>
			
			<div class="form-group">
			<label for="insurance_upto">Insurance Upto</label> 
			<input type="date" name="insurance_upto" placeholder="Insurance Upto"/>
			</div>
			<div class="form-group">
			<label for="fitnessregnupto">Fitness/Regn Upto</label> 
			<input type="date" name="fitness_regn_upto" placeholder="Fitness/Regn Upto"/>
			</div>
			
            <button type="submit" class="btn btn-primary">Submit</button>
			<h1>""</h1>
			


				</form>
			</div>
		</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>