package com.revature.caliber.controllers;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.middleTier.BusinessDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class QCBatchController {

    /***
     * Please change unit tests after connecting controller to midtier OR after
     * changing return values of test data
     ****/

    /**
     * getAllCurrentBatches - REST API method, retrieves all current batches
     *
     * @return - in JSON, a set of batch objects
     */
    @RequestMapping(value = "/qc/batch/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Batch>> getAllCurrentBatches() {

        // Test data - remove and replace with call to midtier
        BusinessDelegate businessDelegate = new BusinessDelegate();
        return new ResponseEntity<>(businessDelegate.getAllBatches(), HttpStatus.OK);
    }

    /**
     * getCurrentBatch - REST API method, retrieves a batch from a list of
     * current batches
     *
     * @param id - batch id
     * @return - in JSON, a batch object
     */
    @RequestMapping(value = "/qc/batch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Batch> getCurrentBatch(@PathVariable int id) {

        // Test data - remove and replace with call to midtier
        BusinessDelegate businessDelegate = new BusinessDelegate();
        Batch batch = businessDelegate.getCurrentBatch();
        batch.setBatchId(id);
        return new ResponseEntity<>(businessDelegate.getCurrentBatch(), HttpStatus.OK);
    }

}
