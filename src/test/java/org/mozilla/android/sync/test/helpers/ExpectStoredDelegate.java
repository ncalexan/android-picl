package org.mozilla.android.sync.test.helpers;

import static org.junit.Assert.assertEquals;

import org.mozilla.android.sync.repositories.domain.Record;

public class ExpectStoredDelegate extends DefaultStoreDelegate {
  String expectedGUID;

  public ExpectStoredDelegate(String guid) {
    this.expectedGUID = guid;
  }
  public ExpectStoredDelegate() {
  }

  public void onStoreSucceeded(Record record) {
    if (this.expectedGUID != null) {
      assertEquals(this.expectedGUID, record.getGUID());
    }
    testWaiter().performNotify();
  }
}