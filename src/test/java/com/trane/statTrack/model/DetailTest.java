package com.trane.statTrack.model;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DetailTest {
  private Detail testDetail;

  @Before
  public void setUp() throws Exception {
testDetail = new Detail("testDetail");
  }

  @Test
  public void detailTimestampsOnCreation() throws Exception {
    assertNotNull("TimeStamp should not be null", testDetail.getTimeStamp());
  }

  @Test
  public void detailDescriptionIsFound() throws Exception {
    assertEquals("testDetail", testDetail.getDescription());
  }

}