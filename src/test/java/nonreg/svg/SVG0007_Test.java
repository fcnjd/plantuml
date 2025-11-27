package nonreg.svg;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/*
Test diagram MUST be put between triple quotes

"""
@startuml
!pragma svginteractive true

class Animal
class Dog
class Cat
class House
class Room

Dog --|> Animal : inherits
Cat --|> Animal
House *-- Room : contains
Dog o-- Cat : knows
Dog --> House : lives in

@enduml
"""

Expected result MUST be put between triple brackets

{{{
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" data-diagram-type="CLASS" preserveAspectRatio="none" version="1.1" zoomAndPan="magnify">
  <defs>
    <style type="text/css"/>
    <script/>
  </defs>
  <g>
    <!--class Animal-->
    <g class="entity" data-entity="Animal" data-source-line="3" data-uid="ent0002" id="entity_Animal">
      <rect fill="#F1F1F1" style="stroke:#181818;stroke-width:0.5;"/>
      <ellipse fill="#ADD1B2" style="stroke:#181818;stroke-width:1;"/>
      <path fill="#000000"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">Animal</text>
      <line style="stroke:#181818;stroke-width:0.5;"/>
      <line style="stroke:#181818;stroke-width:0.5;"/>
    </g>
    <!--class Dog-->
    <g class="entity" data-entity="Dog" data-source-line="4" data-uid="ent0003" id="entity_Dog">
      <rect fill="#F1F1F1" style="stroke:#181818;stroke-width:0.5;"/>
      <ellipse fill="#ADD1B2" style="stroke:#181818;stroke-width:1;"/>
      <path fill="#000000"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">Dog</text>
      <line style="stroke:#181818;stroke-width:0.5;"/>
      <line style="stroke:#181818;stroke-width:0.5;"/>
    </g>
    <!--class Cat-->
    <g class="entity" data-entity="Cat" data-source-line="5" data-uid="ent0004" id="entity_Cat">
      <rect fill="#F1F1F1" style="stroke:#181818;stroke-width:0.5;"/>
      <ellipse fill="#ADD1B2" style="stroke:#181818;stroke-width:1;"/>
      <path fill="#000000"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">Cat</text>
      <line style="stroke:#181818;stroke-width:0.5;"/>
      <line style="stroke:#181818;stroke-width:0.5;"/>
    </g>
    <!--class House-->
    <g class="entity" data-entity="House" data-source-line="6" data-uid="ent0005" id="entity_House">
      <rect fill="#F1F1F1" style="stroke:#181818;stroke-width:0.5;"/>
      <ellipse fill="#ADD1B2" style="stroke:#181818;stroke-width:1;"/>
      <path fill="#000000"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">House</text>
      <line style="stroke:#181818;stroke-width:0.5;"/>
      <line style="stroke:#181818;stroke-width:0.5;"/>
    </g>
    <!--class Room-->
    <g class="entity" data-entity="Room" data-source-line="7" data-uid="ent0006" id="entity_Room">
      <rect fill="#F1F1F1" style="stroke:#181818;stroke-width:0.5;"/>
      <ellipse fill="#ADD1B2" style="stroke:#181818;stroke-width:1;"/>
      <path fill="#000000"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">Room</text>
      <line style="stroke:#181818;stroke-width:0.5;"/>
      <line style="stroke:#181818;stroke-width:0.5;"/>
    </g>
    <g class="link" data-entity-1="Dog" data-entity-2="Animal" data-link-type="implementation" data-uid="lnk7" id="link_Dog_Animal">
      <polygon fill="none" style="stroke:#181818;stroke-width:1;"/>
      <path fill="none" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="13" lengthAdjust="spacing">inherits</text>
    </g>
    <g class="link" data-entity-1="Cat" data-entity-2="Animal" data-link-type="implementation" data-uid="lnk8" id="link_Cat_Animal">
      <polygon fill="none" style="stroke:#181818;stroke-width:1;"/>
      <path fill="none" style="stroke:#181818;stroke-width:1;"/>
    </g>
    <g class="link" data-entity-1="House" data-entity-2="Room" data-link-type="composition" data-uid="lnk9" id="link_House_Room">
      <polygon fill="#181818" style="stroke:#181818;stroke-width:1;"/>
      <path fill="none" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="13" lengthAdjust="spacing">contains</text>
    </g>
    <g class="link" data-entity-1="Dog" data-entity-2="Cat" data-link-type="aggregation" data-uid="lnk10" id="link_Dog_Cat">
      <polygon fill="none" style="stroke:#181818;stroke-width:1;"/>
      <path fill="none" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="13" lengthAdjust="spacing">knows</text>
    </g>
    <g class="link" data-entity-1="Dog" data-entity-2="House" data-link-type="dependency" data-uid="lnk11" id="link_Dog_House">
      <polygon fill="#181818" style="stroke:#181818;stroke-width:1;"/>
      <path fill="none" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="13" lengthAdjust="spacing">lives in</text>
    </g>
  </g>
</svg>
}}}
*/
public class SVG0007_Test extends SvgTest {

	@Test
	void testDataLinkTypeAttribute() throws IOException {
		checkXmlAndDescription("(5 entities)");
	}
}
