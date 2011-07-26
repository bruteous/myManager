package com.personnelmanager.domain.db;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jul 13, 2010
 * Time: 4:07:04 PM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public interface Auditable extends Serializable {
}
