package suites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import db.DbConnectionTest;

@RunWith(Categories.class)
@IncludeCategory(SanityTestSuite.class)
@SuiteClasses ({DbConnectionTest.class})
public class SanityTestSuite {

}
