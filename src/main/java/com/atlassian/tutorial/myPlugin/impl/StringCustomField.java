package com.atlassian.tutorial.myPlugin.impl;


import com.atlassian.jira.issue.customfields.impl.AbstractSingleFieldType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.customfields.persistence.PersistenceFieldType;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;


@Scanned
public class StringCustomField extends AbstractSingleFieldType<String> {
    @ComponentImport CustomFieldValuePersister customFieldValuePersister;
    @ComponentImport GenericConfigManager genericConfigManager;
    public StringCustomField(CustomFieldValuePersister customFieldValuePersister, GenericConfigManager genericConfigManager) {
        super(customFieldValuePersister, genericConfigManager);
        this.customFieldValuePersister = customFieldValuePersister;
        this.genericConfigManager = genericConfigManager;
    }

    @Override
    protected PersistenceFieldType getDatabaseType() {
        return PersistenceFieldType.TYPE_UNLIMITED_TEXT;
    }

    @Override
    protected Object getDbValueFromObject(String s) {
        return null;
    }

    @Override
    protected String getObjectFromDbValue(Object o) throws FieldValidationException {
        return getStringFromSingularObject((String) o);
    }

    @Override
    public String getStringFromSingularObject(String singularObject) {
if (singularObject == null){
    return null;
} else return singularObject;

    }

    @Override
    public String getSingularObjectFromString(String s) throws FieldValidationException {
      if (s == null){  return null;}



          if (BalancedParenthisisCheck.checkBalance(s) == false) {
              throw new FieldValidationException("You have not close or opene the parenthisis");
          }
          return s;

    }

}