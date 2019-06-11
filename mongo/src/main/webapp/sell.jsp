<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
    <br>
    <br>
    
   
    <div class="container">
    <form class="form-signin" action="prog" method="POST">
      <h2 class="form-signin-heading">Find your happy</h2>
      <h3 class="form-signin-heading">Search properties for sale and to rent in INDIA</h3>
        <p>
            Property Type:  <select name="type" class="form-control" required autofocus>
          <option value="Any">Any</option>
          <option value="House">House</option>
          <option value="Flat/Appartment">Flat/Appartment</option>
          <option value="Bungalows">Bungalows</option>
          <option value="Land">Land</option>
          <option value="Commercial Property">Commercial Property</option>
          <option value="Others">Others</option>
        </select> 
      </p>
      <p>

        No of Bedrooms: <input type="text" size="45" name="no_of_bedrooms"  >  </p>
         <p>
         <label for="City" class="sr-only">City</label>
         City :
         <input  name="city" size="45" placeholder="e.g. &#39; Tirupathi&#39;, &#39;Chennai&#39; Or &#39;Banglore&#39; " type="text" />
     </p>
        <button  class="btn btn-lg btn-primary btn-block" type="submit"  name="buy" value="For sale">For sale</button>
        <button   class="btn btn-lg btn-primary btn-block" type="submit"  name="rent" value="To rent">To rent</button>
   
    </form>
  </div>
<br><br>

<div class="container">
   <form class="form-signin" action="prop" method="post">
    <h2 class="form-signin-heading">Post Your Property Here</h2>
       
    <p>
        
      Property Type: <select name="type" class="form-control" required autofocus>
        
        <option value="House">House</option>
        <option value="Flat/Appartment">Flat/Appartment</option>
        <option value="Bungalows">Bungalows</option>
        <option value="Land">Land</option>
        <option value="Commercial Property">Commercial Property</option>
        <option value="Others">Others</option>
      </select> 
    </p>
    <p>
      <label for="No Of Bedrooms" size="45"  class="sr-only">No Of Bedrooms</label>
      No of Bedrooms: <input type="text" size="45" name="no_of_bedrooms"  >  </p>
       <p>
       <label for="City" class="sr-only">City</label>
       City : <input  name="city" size="45" placeholder="e.g. &#39; Tirupathi&#39;, &#39;Chennai&#39; Or &#39;Banglore&#39; " type="text" />
   </p>
   <p>
       <label for="Pincode" class="sr-only">Pincode</label>
       Pincode : <input type="text" size="45" name="pincode"  > 
   </p>
   <p>
   <label for="Price" class="sr-only">Price</label>
   Price :
   <input type="text" size="45" name="price"   > 
  </p> 
  <p>
    <label for="Location" class="sr-only">Location</label>
    Location :
    <input type="text" size="45" name="location"   > 
   </p>
  <p>
    <label for="Keyfields" class="sr-only">Keyfeatures</label>

    Key Features :   <textarea rows="10" cols="50" name="keyf">  </textarea>
  </p>   
  <p>
    <label for="Desc" class="sr-only">Descreption</label>

    Full Descreption:   <textarea rows="10" cols="50" name="desc">  </textarea>

  </p>
  <p>
    <label for="Desc" class="sr-only">Descreption</label>
    <input type="file" name="path" id="fileToUpload">
  </p>
   <input class="btn btn-lg btn-primary btn-block" type="submit" value="Post" >

   </form>
  </div>  
    
</body>
</html>

