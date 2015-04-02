/**
 * Copyright 2014 Kyle Chamberlin
 *
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * <p>
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.kentcommunications.paf;

import com.bccsoftware.ProductWebIntegrations2.PafSvc.IPafSvc;
import com.bccsoftware.ProductWebIntegrations2.PafSvc.PafSvcESortDirections;
import com.bccsoftware.ProductWebIntegrations2.PafSvc.PafSvcLocator;
import com.bccsoftware.ProductWebIntegrations2.PafSvc.PafSvcTPaf;
import com.bccsoftware.ProductWebIntegrations2.PafSvc.PafSvcTPafs_GetList_SimpleRecord;
import com.bccsoftware.ProductWebIntegrations2.PafSvc.PafSvcTPafs_GetList_SimpleResult;

import java.util.GregorianCalendar;
import java.util.HashMap;

import static java.io.File.separatorChar;

public class Main {

  public static HashMap<String, String> fields;

  private static final String BCC_API_KEY = System.getenv("BCC_API_KEY");
  private static final String BCC_USERNAME = System.getenv("BCC_USERNAME");
  private static final String BCC_PASSWORD = System.getenv("BCC_PASSWORD");

  public static void main(String[] args) throws Exception {

    PafSvcLocator locator = new PafSvcLocator();
    IPafSvc iPafSvc = locator.getBasicHttpBinding_IPafSvc();

    PafSvcTPafs_GetList_SimpleResult getListSimpleResult = iPafSvc.pafs_GetList_Simple(
        BCC_API_KEY, BCC_USERNAME, BCC_PASSWORD, 9616, "",
        new GregorianCalendar(2015, 0, 1),  new GregorianCalendar(2015, 3, 1), "", "",
        "", 1, 256, "vchCompanyName", PafSvcESortDirections.Asc, "");

    PafSvcTPafs_GetList_SimpleRecord[] records = getListSimpleResult.getRecords();

    for (PafSvcTPafs_GetList_SimpleRecord record : records) {
      PafSvcTPaf paf = iPafSvc.paf_Get(BCC_API_KEY, BCC_USERNAME, BCC_PASSWORD,
          9616, record.getBccPafId()).getPaf();

      stamp(paf);
    }
  }

  private static void stamp(PafSvcTPaf paf) throws Exception {
    fields = new HashMap<>();
    fields.put("List Owner", paf.getCompanyName());
    fields.put("Company", paf.getCompanyName());
    fields.put("Contact", paf.getPafContact());
    fields.put("Name", paf.getPafContact());
    fields.put("Address", paf.getAddress());
    fields.put("City", paf.getCity());
    fields.put("State", paf.getState());
    fields.put("Zip", paf.getZip());
    fields.put("Telephone Number", phoneFormat(paf.getPhone()));
    fields.put("NAICS", paf.getNaics());
    fields.put("Mailer ID", paf.getMailerId());
    fields.put("Email", paf.getEmail());
    fields.put("Parent", paf.getParentCompanyName());
    fields.put("DBA", paf.getAlternateCompanyName());
    fields.put("Title", paf.getPafContactTitle());

    StampFields sf = new StampFields();
    sf.stampPdf("pdfs" + separatorChar + paf.getCompanyName().concat(".pdf"), fields);
  }

  public static String phoneFormat(String phoneNumber) {
    if (phoneNumber.length() >= 10)
      return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
          + phoneNumber.substring(6);
    if (phoneNumber.length() == 7)
      return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3);
    return phoneNumber;
  }
}
