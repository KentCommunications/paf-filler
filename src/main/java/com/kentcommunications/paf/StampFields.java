package com.kentcommunications.paf;

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

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.util.HashMap;

public class StampFields {

  public void stampPdf(String dest, HashMap<String, String> fields) throws Exception {
    PdfReader reader = new PdfReader(getClass().getResource("/Form.pdf"));
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    AcroFields form = stamper.getAcroFields();

    fields.forEach((field, value) -> {
        try {
          form.setField(field, value);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

    stamper.close();
  }
}
