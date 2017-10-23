/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.shelf;

import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.shelf.Shelf;

/**
 *
 * @author Suzn
 */
public interface ShelfDAO extends DAO<Shelf> {

    boolean isShelfAvailable(Shelf shelf);

}
