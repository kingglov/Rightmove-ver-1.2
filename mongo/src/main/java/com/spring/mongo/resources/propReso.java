package com.spring.mongo.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import com.mongodb.BasicDBObject;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.spring.mongo.daos.propDaos;
import com.spring.mongo.model.properties;
import com.spring.mongo.repository.propertiesrepo;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class propReso {

    private propertiesrepo propertiesRepo;
    private GridFsTemplate gridFsTemplate;
    private String imageFileId = "";

    GridFS gridFS;
    GridFSBucket gridFSBucket;
    GridFsOperations gridFsOperations;

    private propReso(propertiesrepo propertiesrepo) {
        this.propertiesRepo = propertiesrepo;

    }

    @RequestMapping("sell")
    public ModelAndView search(properties pro) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sell");
        return mv;
        // @PathVariable String fileId,
    }

    @RequestMapping("prop")
    public ModelAndView PostPro(properties pro) throws FileNotFoundException {

        propDaos pr = new propDaos(propertiesRepo);
        Boolean k = pr.insert(pro);

        // ******************* Saving image ******************************
         // Define metaData
         DBObject metaData = new BasicDBObject();
         metaData.put("Rightmove", "JavaSampleApproach");
 
         // Get input file
         InputStream iamgeStream = new FileInputStream("c:\\hi.jpg");
 
         metaData.put("type", "image");
 
         // Store file to MongoDB
         imageFileId = gridOperations.store(iamgeStream, "RightmoveGani.jpg", "image/jpg", metaData).get().toString();


        ModelAndView mv = new ModelAndView();
        mv.addObject("obj", pro);
        mv.setViewName("show1");
        return mv;

    }

    @Autowired
    GridFsOperations gridOperations;
// ************************** Help here *******************************
    @RequestMapping(value = "getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<GridFsResource> getFile() {
        String fileId = "5cf6482fcf2e89340406b230";
        System.out.println(fileId);
        GridFSFile file = gridOperations.findOne(Query.query(Criteria.where("_id").is(fileId)));
        System.out.println(file + "******************To see in console******************");
        ResponseEntity<GridFsResource> k = ResponseEntity.ok().contentLength(file.getLength())
                .body(gridFsOperations.getResource(file));

        System.out.println(k + "******************To see in console******************");
        return k;
    }
    //

    // To get properties
    @RequestMapping("prog")
    public ModelAndView getPro(properties pro) throws IOException {
        propDaos pr = new propDaos(propertiesRepo);
        List prr = pr.getProp(pro);
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj", prr);
        mv.setViewName("show");
        return mv;

    }

  @GetMapping("/delete/image")
  public String deleteFile(){
    // delete image via id
    gridOperations.delete(new Query(Criteria.where("_id").is(imageFileId)));
    
    return "Done";
  }

    //  
    public ModelAndView error(String error){

        ModelAndView mv = null;
        mv.addObject("error", error);
        mv.setViewName("error");

        return mv;
    }
    
 

        // This is also not working ************************
    @RequestMapping(value = "/image", method = RequestMethod.GET ,produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] download() throws IllegalStateException, IOException {
        
        imageFileId =  "5cf6482fcf2e89340406b230";
        GridFSFile file = gridOperations.findOne(new Query(Criteria.where("_id").is(imageFileId)));
    System.out.println(file+"************* to confirm  *************");

         String gg = gridFsTemplate.getResource(file).toString();
       
        System.out.println(gg);

        InputStream inputStream = gridFsTemplate.getResource(file).getInputStream();            

        byte[] k = IOUtils.toByteArray(inputStream);
             return k;

    }

    
    
}
