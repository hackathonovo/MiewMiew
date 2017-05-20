//
//  ActionDetailsViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//
//  This file was generated by the 🐍 VIPER generator
//

import UIKit
import GoogleMaps

final class ActionDetailsViewController: UIViewController {
    
    @IBOutlet weak var mapView: GMSMapView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var statusLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var timeLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    
    @IBOutlet weak var userNameLabel: UILabel!
    
    // MARK: - Public properties -
    
    var presenter: ActionDetailsPresenterInterface!
    
    // MARK: - Lifecycle -
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        
        title = "Action details"
        _setupMap()
    }
    
    fileprivate func _setupMap() {
        let camera = GMSCameraPosition.camera(withLatitude: -33.8680, longitude: 151.2086, zoom: 14)
        let mapView = GMSMapView.map(withFrame: .zero, camera: camera)
        self.mapView = mapView
    }
    
    @IBAction func didSelectShowMembersAction(_ sender: Any) {
        
    }
}

// MARK: - Extensions -

extension ActionDetailsViewController: ActionDetailsViewInterface {
    
    func setupView(with action: RescueAction) {
        titleLabel.text = action.name
        statusLabel.text = action.rescueLifecycle?.rawValue
        descriptionLabel.text = action.actionDescription
        dateLabel.text = action.dateTime.formattedDate()
        timeLabel.text = action.dateTime.formattedTime()
    }
}
