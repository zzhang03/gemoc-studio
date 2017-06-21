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
import org.eclipse.gemoc.sequential.language.wb.sample.deployer.wizards.TFSM_PlainK3ExampleWizard;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TFSM_PlainK3ExampleWizardTest {
	
static IWorkspaceRoot wsRoot;
	
	@BeforeClass
	public static void setUp(){
		TFSM_PlainK3ExampleWizard sample = new TFSM_PlainK3ExampleWizard();
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
		IProject project1 = wsRoot.getProject("org.gemoc.sample.tfsm.plaink3.design");
		assertEquals("Ooops", true, project1.exists());
	}
	
	@Test
	public void testExist2(){
		IProject project1 = wsRoot.getProject("org.gemoc.sample.tfsm.plaink3.dsa");
		assertEquals("Ooops", true, project1.exists());
	}
	
	@Test
	public void testExist3(){
		IProject project1 = wsRoot.getProject("org.gemoc.sample.tfsm.plaink3.model");
		assertEquals("Ooops", true, project1.exists());
	}
	
	@Test
	public void testExist4(){
		IProject project1 = wsRoot.getProject("org.gemoc.sample.tfsm.plaink3.xdsml");
		assertEquals("Ooops", true, project1.exists());
	}
}
