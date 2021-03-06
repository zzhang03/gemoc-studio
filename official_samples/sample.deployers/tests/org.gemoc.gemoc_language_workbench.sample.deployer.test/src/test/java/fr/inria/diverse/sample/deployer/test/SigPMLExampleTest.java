/*******************************************************************************
 * Copyright (c) 2015, 2017  Inria  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package fr.inria.diverse.sample.deployer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.gemoc.sequential.language.wb.sample.deployer.wizards.SigPMLExampleWizard;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SigPMLExampleTest {

	static IWorkspaceRoot wsRoot;
	
	@BeforeClass
	public static void setUp(){
		SigPMLExampleWizard sample = new SigPMLExampleWizard();
		sample.performFinish();
		wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResourcesSetupUtil.waitForAutoBuild();
	}

	@AfterClass
	public static void cleanUp(){
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		for (IProject iProject : projects) {
			try {
				iProject.delete(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testNoErrorsInWorkspace(){
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		for (IProject iProject : projects) {
			try {
				IMarker[] markers = iProject.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				for (IMarker iMarker : markers) {
					assertFalse("Unexpected marker: " + iMarker.getAttribute(IMarker.MESSAGE), iMarker.getAttribute(IMarker.SEVERITY).equals(IMarker.SEVERITY_ERROR));
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testExist1(){
		IProject project1 = wsRoot.getProject("fr.cnrs.luchogie.ultimateplotter");
		assertEquals("Ooops", true, project1.exists());
	}
	
	@Test
	public void testExist2(){
		IProject project2 = wsRoot.getProject("org.gemoc.sample.sigpml.model.design");
		assertEquals("Ooops", true, project2.exists());
	}
	
	@Test
	public void testExist3(){
		IProject project3 = wsRoot.getProject("org.gemoc.sample.sigpml.k3dsa");
		assertEquals("Ooops", true, project3.exists());
	}
	
	@Test
	public void testExist4(){
		IProject project4 = wsRoot.getProject("org.gemoc.sample.sigpml.moc.application");
		assertEquals("Ooops", true, project4.exists());
	}
	
	@Test
	public void testExist5(){
		IProject project5 = wsRoot.getProject("org.gemoc.sample.sigpml.moc.lib");
		assertEquals("Ooops", true, project5.exists());
	}
	
	@Test
	public void testExist6(){
		IProject project6 = wsRoot.getProject("org.gemoc.sample.sigpml.model");
		assertEquals("Ooops", true, project6.exists());
	}
	
	@Test
	public void testExist7(){
		IProject project7 = wsRoot.getProject("org.gemoc.sample.sigpml.model.edit");
		assertEquals("Ooops", true, project7.exists());
	}
	
	@Test
	public void testExist8(){
		IProject project8 = wsRoot.getProject("org.gemoc.sample.sigpml.model.editor");
		assertEquals("Ooops", true, project8.exists());
	}
	
	@Test
	public void testExist9(){
		IProject project9 = wsRoot.getProject("org.gemoc.sample.sigpml.xdsml");
		assertEquals("Ooops", true, project9.exists());
	}
}
